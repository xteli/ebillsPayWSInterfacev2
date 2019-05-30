/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.util;

import com.nibssplc.ussd.ebillspay.api.dto.response.helper.FormField;
import com.nibssplc.ussd.ebillspay.api.dto.request.ValidationRequest;
import com.nibssplc.ussd.ebillspay.api.dto.response.NotificationResponse;
import com.nibssplc.ussd.ebillspay.api.dto.response.ValidationResponse;
import com.nibssplc.ussd.ebillspay.api.dto.response.helper.PaymentDetail;
import com.nibssplc.ussd.ebillspay.api.dto.response.helper.ValidationResponseHeader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author cojiteli
 */
public class EBillsPayServiceUtil {

    Parser parser = null;
    String serviceURL;
    static Map responseCodes = new HashMap();

    static {
        responseCodes.put("00", "00");
        responseCodes.put("200", "00");
        responseCodes.put("500", "96");
        responseCodes.put("422", "17");
        responseCodes.put("404", "25");
        responseCodes.put("40", "69");
        responseCodes.put("41", "69");
        responseCodes.put("42", "69");
        responseCodes.put("43", "69");
        responseCodes.put("44", "69");
        responseCodes.put("45", "69");
        responseCodes.put("46", "69");
        responseCodes.put("25", "25");
        responseCodes.put("52", "25");
    }

    public EBillsPayServiceUtil() {

    }

    public EBillsPayServiceUtil(String serviceURL) {
        //   this();
        this.serviceURL = serviceURL;
    }

    public ValidationResponse doValidation(String clientCode, String requestXML) {
        System.out.println("Request for NIBSS USSD Payment : " + requestXML);
        ValidationResponse valResp = null;
        ValidationResponse valRespAmt = null;
        ValidationRequest valReq = null;
        String code = null;
        String amtRequestXML = "";
        valReq = convertValidationRequestXMLStringToObject(requestXML);

        //remove amount parameter for branch
        if ("259".equals(valReq.getValidationHeader().getBillerId()) && requestXML.contains("<Record><Name>Amount</Name>")) {
            String reqArr[] = requestXML.split("<Record><Name>Amount</Name>");
            requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
            valReq = convertValidationRequestXMLStringToObject(requestXML);
        }

        //manipulate xml request for LSHS
        if ("192".equals(valReq.getValidationHeader().getBillerId())) {
//            if (requestXML.contains("<Record><Name>Amount</Name>")) {
//                String reqArr[] = requestXML.split("<Record><Name>Amount</Name>");
//                requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
//            }
//            if (requestXML.contains("<Record><Name>amount</Name>")) {
//                String reqArr[] = requestXML.split("<Record><Name>amount</Name>");
//                requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
//            }
            if (requestXML.contains("<Record><Name>policyNumber</Name>")) {
                String reqArr[] = requestXML.split("<Record><Name>policyNumber</Name><Value>");
                requestXML = reqArr[0] + "<Record><Name>client_code</Name><Value>LSHS_001</Value></Record><Record><Name>policyNumber</Name><Value>LSHS-" + reqArr[1];
            }
        }

        //manipulate xml request for Alimosho
        if ("326".equals(valReq.getValidationHeader().getBillerId())) {
//            if (requestXML.contains("<Record><Name>Amount</Name>")) {
//                String reqArr[] = requestXML.split("<Record><Name>Amount</Name>");
//                requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
//            }
//            if (requestXML.contains("<Record><Name>amount</Name>")) {
//                String reqArr[] = requestXML.split("<Record><Name>amount</Name>");
//                requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
//            }
            if (requestXML.contains("<Record><Name>billerRef</Name>")) {
                String reqArr[] = requestXML.split("<Record><Name>billerRef</Name>");
                requestXML = reqArr[0] + "<Record><Name>user</Name><Value>nibss22121</Value></Record><Record><Name>passcode</Name><Value>P#86235wD</Value></Record><Record><Name>billerRef</Name>" + reqArr[1];
            }
            valReq = convertValidationRequestXMLStringToObject(requestXML);
        }
        String responseString = postRequest(clientCode, requestXML, "V");
        System.out.println(responseString);
        if (!responseString.equals("")) {
            valResp = convertValidationResponseXMLStringToObject(responseString);
        }
        if (valResp != null) {
            ValidationResponseHeader header = valResp.getValidationHeader();
            if (header != null) {
                code = (String) responseCodes.get(header.getResponseCode());
                if (code != null && "00".equals(code)) {
                    if ("294".equals(valReq.getValidationHeader().getBillerId())) {
                        amtRequestXML = requestXML;
                        String amountPaid = "";
                        List<FormField> formField = valResp.getProductForm().getFormField();
                        for (FormField form : formField) {
                            if ("amount".equals(form.getName())) {
                                amountPaid = form.getDefaultValue();
                                break;
                            }
                        }
                        amtRequestXML = amtRequestXML.replace("<Step>1</Step>", "<Step>2</Step>").replace("<FormId>1479</FormId>", "<FormId>1480</FormId>").replace("<Record><Name>Amount</Name><Value>0</Value></Record>", "<Record><Name>amountPaid</Name><Value>" + amountPaid + "</Value></Record><Record><Name>phoneNumber</Name><Value></Value></Record><Record><Name>email</Name><Value></Value></Record>");
                        String valAmountResponseString = postRequest(clientCode, amtRequestXML, "V");
                        System.out.println(valAmountResponseString);
                        if (!valAmountResponseString.equals("")) {
                            valRespAmt = convertValidationResponseXMLStringToObject(valAmountResponseString);
                            if (valRespAmt != null) {
                                ValidationResponseHeader headerAmt = valRespAmt.getValidationHeader();
                                if (headerAmt != null) {
                                    String codeAmt = (String) responseCodes.get(headerAmt.getResponseCode());
                                    headerAmt.setResponseCode(codeAmt == null ? headerAmt.getResponseCode() : codeAmt);
                                    valRespAmt.setValidationHeader(headerAmt);
                                    System.out.println(valRespAmt);
                                }
                            }
                        }
                    } else if ("259".equals(valReq.getValidationHeader().getBillerId())) {
                        amtRequestXML = requestXML;
                        String amountPaid = "", outstandingAmount = "", loanId = "", name = "";
                        List<FormField> formField = valResp.getProductForm().getFormField();
                        for (FormField form : formField) {
                            if ("Amount".equals(form.getName())) {
                                amountPaid = form.getDefaultValue();
                                outstandingAmount = form.getDefaultValue();
                            }
                            if ("branchRegisteredLegalName".equals(form.getName())) {
                                name = form.getDefaultValue();
                            }
                            if ("loanid".equals(form.getName())) {
                                loanId = form.getDefaultValue();
                            }
                        }
                        amtRequestXML = amtRequestXML.replace("<FormId>1176</FormId>", "<FormId>1177</FormId>").replace("<Step>1</Step>", "<Step>2</Step>").replace("</CustomerInformationValidationRequest>", "<Record><Name>amountpaid</Name><Value>" + amountPaid + "</Value></Record><Record><Name>Amount</Name><Value>" + outstandingAmount + "</Value></Record><Record><Name>branchRegisteredLegalName</Name><Value>" + name + "</Value></Record><Record><Name>loanid</Name><Value>" + loanId + "</Value></Record></CustomerInformationValidationRequest>");
                        String valAmountResponseString = postRequest(clientCode, amtRequestXML, "V");
                        System.out.println(valAmountResponseString);
                        if (!valAmountResponseString.equals("")) {
                            valRespAmt = convertValidationResponseXMLStringToObject(valAmountResponseString);
                            if (valRespAmt != null) {
                                ValidationResponseHeader headerAmt = valRespAmt.getValidationHeader();
                                if (headerAmt != null) {
                                    String codeAmt = (String) responseCodes.get(headerAmt.getResponseCode());
                                    headerAmt.setResponseCode(codeAmt == null ? headerAmt.getResponseCode() : codeAmt);
                                    valRespAmt.setValidationHeader(headerAmt);
                                    System.out.println(valRespAmt);
                                }
                            }
                        }
                    } else {
                        header.setResponseCode(code);
                        valResp.setValidationHeader(header);
                        System.out.println(valResp);
                    }
                } else {
                    header.setResponseCode(code == null ? header.getResponseCode() : code);
                    valResp.setValidationHeader(header);
                }
            }
        }
        return ("294".equals(valReq.getValidationHeader().getBillerId()) || "259".equals(valReq.getValidationHeader().getBillerId())) ? valRespAmt : valResp;

    }

    public ValidationResponse doValidation_Old(String clientCode, String requestXML) {
        ValidationResponse valResp = null;
        ValidationRequest valReq = null;
        String code = null;
        valReq = convertValidationRequestXMLStringToObject(requestXML);

        //remove amount parameter for branch
        //This parameter was inputted from the USSD Payment Engine by default
        if ("259".equals(valReq.getValidationHeader().getBillerId()) && requestXML.contains("<Record><Name>Amount</Name>")) {
            String reqArr[] = requestXML.split("<Record><Name>Amount</Name>");
            requestXML = reqArr[0] + "</CustomerInformationValidationRequest>";
        }

        String responseString = postRequest(clientCode, requestXML, "V");
        System.out.println(responseString);
        if (!responseString.equals("")) {
            valResp = convertValidationResponseXMLStringToObject(responseString);
        }
        if (valResp != null) {
            ValidationResponseHeader header = valResp.getValidationHeader();
            if (header != null) {
                code = (String) responseCodes.get(header.getResponseCode());
                if (code != null && "00".equals(code)) {
                    header.setResponseCode(code);
                    valResp.setValidationHeader(header);
                    System.out.println(valResp);
                } else {
                    header.setResponseCode(code == null ? header.getResponseCode() : code);
                    valResp.setValidationHeader(header);
                }
            }
        }
        return valResp;
    }

    public NotificationResponse doNotification(String contentType, String requestXML) {
        NotificationResponse conResp = null;
        String code = null;
        String responseString = sendRequest(contentType, requestXML, "N");
        System.out.println(responseString);
        if (!responseString.equals("")) {
            conResp = convertNotificationResponseXMLStringToObject(responseString);
        }
        if (conResp != null) {
            code = (String) responseCodes.get(conResp.getResponseCode());
            conResp.setResponseCode(code == null ? conResp.getResponseCode() : code);
        }
        return conResp;
    }

    public PaymentDetail doPaymentReceipt(String requestXML) {
        PaymentDetail payDetail = null;
        String responseString = sendRequest("", requestXML, "N");
        if (!responseString.equals("")) {
            payDetail = convertPaymentReceiptXMLStringToObject(responseString);
        }
        return payDetail;
    }

    String sendRequest(String headerParam, String requestXML, String operationMode) {
        String responseBody = "";
        System.out.println("**** post URL  = " + this.serviceURL);
        try {
            WebTarget target = ClientBuilder.newClient().target(this.serviceURL);

            target = operationMode.equals("N") ? (WebTarget) target.register(new ClientFilter("", "application/xml")) : (WebTarget) target.register(new ClientFilter(headerParam, "application/xml"));
            Response response = (Response) target.request(new String[]{"application/xml"}).post(Entity.text(requestXML), Response.class);
            responseBody = (String) response.readEntity(String.class);
            System.out.println("**** response Body = " + responseBody);
            System.out.println("**** response Status = " + response.getStatus());
        } catch (Exception ex) {
            responseBody = "";
            ex.printStackTrace();
        }
        return responseBody;
    }

    String sendRequest_old(String headerParam, String requestXML, String operationMode) {
        //  String USER_AGENT = "Mozilla/5.0";
        String responseBody = "";
        System.out.println("**** post URL  = " + serviceURL);
        try {
            //  HttpsURLConnection.setDefaultHostnameVerifier(trustAllCertificates());
            WebTarget target = ClientBuilder.newClient().target(serviceURL);
            // target = headerParam.equals("") ? target.register(new ClientFilter("", headerParam)) : target.register(new ClientFilter(headerParam, ""));
            target = operationMode.equals("N") ? target.register(new ClientFilter("", headerParam)) : target.register(new ClientFilter(headerParam, "application/xml"));
            Response response = target.request(MediaType.APPLICATION_XML).post(Entity.text(requestXML), Response.class);
            responseBody = response.readEntity(String.class);
            System.out.println("**** response Body = " + responseBody);
            System.out.println("**** response Status = " + response.getStatus());
        } catch (Exception ex) {
            responseBody = "";
            ex.printStackTrace();
        }
        return responseBody;
    }

    String postRequest(String headerParam, String requestXML, String operationMode) {
        StringBuilder response = new StringBuilder();
        String USER_AGENT = "Mozilla/5.0";
        System.out.println("**** post URL  = " + serviceURL);
        try {

            HttpsURLConnection.setDefaultHostnameVerifier(trustAllCertificates());
            URL urlObject = new URL(serviceURL);
            try {
                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestProperty("User-Agent", USER_AGENT);
                connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                connection.setRequestProperty("Accept", "application/xml");
                connection.setRequestProperty("Content-Type", "application/xml");
                if (operationMode.equals("V")) {
                    connection.setRequestProperty("clientCode", headerParam);
                }
                // Send post request
                connection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(requestXML);
                wr.flush();
                wr.close();

                int responseCode = connection.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + serviceURL);
                System.out.println("Post parameters : " + requestXML);
                System.out.println("Response Code : " + responseCode);
//
                BufferedReader in = new BufferedReader(
                        new InputStreamReader((200 <= responseCode && responseCode <= 299) ? connection.getInputStream() : connection.getErrorStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            } catch (Exception sdz) {
                sdz.printStackTrace();
                return null;
            }

        } catch (Exception sd) {

            sd.printStackTrace();
            return null;
        }

    }

    ValidationResponse convertValidationResponseXMLStringToObject(String xmlString
    ) {
        ValidationResponse valResp = null;

        try {
            parser = new Parser<ValidationResponse>(ValidationResponse.class
            );
            valResp = (ValidationResponse) parser.convertXMLStringToObject(xmlString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return valResp;
    }

    NotificationResponse convertNotificationResponseXMLStringToObject(String xmlString
    ) {
        NotificationResponse confResponse = null;

        try {
            parser = new Parser<NotificationResponse>(NotificationResponse.class
            );
            confResponse = (NotificationResponse) parser.convertXMLStringToObject(xmlString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return confResponse;
    }

    ValidationRequest convertValidationRequestXMLStringToObject(String xmlString) {
        ValidationRequest valReq = null;
        try {
            this.parser = new Parser(ValidationRequest.class);

            valReq = (ValidationRequest) this.parser.convertXMLStringToObject(xmlString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return valReq;
    }

    PaymentDetail convertPaymentReceiptXMLStringToObject(String xmlString) {
        PaymentDetail paymentReceipt = null;
        try {
            this.parser = new Parser(PaymentDetail.class);
            paymentReceipt = (PaymentDetail) this.parser.convertXMLStringToObject(xmlString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return paymentReceipt;
    }

    private HostnameVerifier trustAllCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        return allHostsValid;
    }

}
