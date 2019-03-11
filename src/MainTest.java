
;
import com.nibss.ussd.util.BVNRequestManager;
import com.nibss.ussd.util.ICADRequestManager;
import com.nibssplc.ussd.ebillspay.api.dto.response.NotificationResponse;
import com.nibssplc.ussd.ebillspay.api.dto.response.ValidationResponse;
import com.nibssplc.ussd.ebillspay.api.util.EBillsPayServiceUtil;
import com.nibssplc.ussd.ebillspay.api.util.SSMCrytpoClass;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cojiteli
 */


class MainTest {

    static SSMCrytpoClass crypto = new SSMCrytpoClass("http://10.7.7.204:8500/nip/crypto?wsdl");
    static String validationUrl = "http://196.6.103.10:9080/ebillspayservices/forms/validation/ui/ussd";
    static String notificationUrl = "http://10.7.7.75:9080/ebillspayscheduler/notify/by/sessionid";
//     static String validationUrl = "http://localhost:9080/ebillspayservices/forms/validation/ui";
//    static String notificationUrl = "http://localhost:9080/ebillspayscheduler/notify/by/sessionid";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String livingFaithXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<CustomerInformationValidationRequest>\n"
                + "   <Header>\n"
                + "      <SessionId>999999</SessionId>\n"
                + "      <BillerId>84</BillerId>\n"
                + "      <ProductId>102</ProductId>\n"
                + "      <FormId>223</FormId>\n"
                + "      <SourceBankCode>232</SourceBankCode>\n"
                + "      <InstitutionCode>999999</InstitutionCode>\n"
                + "      <ChannelCode>2</ChannelCode>\n"
                + "      <PayerName>ANYASOR CHIGOZIE</PayerName>\n"
                + "      <PayerAccountNumber>0005969437</PayerAccountNumber>\n"
                + "      <Step>1</Step>\n"
                + "      <EchoData>8tzjb+PrersJa41vnesTiAAnpgBGo9ShcY7HpIm9x7w=</EchoData>\n"
                + "   </Header>\n"
                + "   <Record>\n"
                + "      <Name>portalid</Name>\n"
                + "      <Value>ussd</Value>\n"
                + "   </Record>\n"
                + "   <Record>\n"
                + "      <Name>amount</Name>\n"
                + "      <Value>1500</Value>\n"
                + "   </Record>\n"
                + "   <AES>false</AES>\n"
                + "</CustomerInformationValidationRequest>";

        String kanoDCXML = "<CustomerInformationValidationRequest><Header><SessionId>999070170912120513204276135315</SessionId><BillerId>90</BillerId><ProductId>109</ProductId><FormId>249</FormId><SourceBankCode>070</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>KNED-DALA COLLECTION ACCOUNT</PayerName><PayerAccountNumber>5020128821</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>Phone</Name><Value>62120142567</Value></Record><Record><Name>Amount</Name><Value>2000</Value></Record><Record><Name>Meter No</Name><Value>62120142567</Value></Record><Record><Name>Confirm Amount</Name><Value>2000</Value></Record><Record><Name>Amount</Name><Value>2000</Value></Record></CustomerInformationValidationRequest>";

        String ikedcXML = "<CustomerInformationValidationRequest>\n"
                + "<Header>\n"
                + "<SessionId>123456789012345678901234567890</SessionId>\n"
                + "<BillerId>33</BillerId>\n"
                + "<ProductId>37</ProductId>\n"
                + "<FormId>79</FormId>\n"
                + "<SourceBankCode>058</SourceBankCode>\n"
                + "<InstitutionCode>000058</InstitutionCode>\n"
                + "<ChannelCode>002</ChannelCode>\n"
                + "<BranchCode>003</BranchCode>\n"
                + "<PayerName>UFORO UNWANA ENOBONG</PayerName>\n"
                + "<PayerAccountNumber>0051762787</PayerAccountNumber>\n"
                + "<Step>1</Step>\n"
                + "<NextStep></NextStep>\n"
                + "</Header>\n"
                + "<Record>\n"
                + "<Name>Meter No</Name>\n"
                + "<Value>0100928151</Value>\n"
                + "</Record>\n"
                + "</CustomerInformationValidationRequest>";

        String gnldXML = "<CustomerInformationValidationRequest>\n"
                + "<Header>\n"
                + "<SessionId>123456789012345678901234567890</SessionId>\n"
                + "<BillerId>88</BillerId>\n"
                + "<ProductId>106</ProductId>\n"
                + "<FormId>235</FormId>\n"
                + "<SourceBankCode>058</SourceBankCode>\n"
                + "<InstitutionCode>000058</InstitutionCode>\n"
                + "<ChannelCode>002</ChannelCode>\n"
                + "<BranchCode>003</BranchCode>\n"
                + "<PayerName>UFORO UNWANA ENOBONG</PayerName>\n"
                + "<PayerAccountNumber>0051762787</PayerAccountNumber>\n"
                + "<Step>1</Step>\n"
                + "<NextStep></NextStep>\n"
                + "</Header>\n"
                + "<Record>\n"
                + "<Name>referenceNumber</Name>\n"
                + "<Value>1612192700</Value>\n"
                + "</Record>\n"
                //                + "<Record>\n"
                //                + "<Name>Amount</Name>\n"
                //                + "<Value>1</Value>\n"
                //                + "</Record>\n"
                + "</CustomerInformationValidationRequest>";

        String gnldXML1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<CustomerInformationValidationRequest>\n"
                + "   <Header>\n"
                + "      <SessionId>999058170913100737479510804656</SessionId>\n"
                + "      <BillerId>88</BillerId>\n"
                + "<ProductId>106</ProductId>\n"
                + "<FormId>235</FormId>\n"
                + "      <SourceBankCode>058</SourceBankCode>\n"
                + "      <InstitutionCode>999070</InstitutionCode>\n"
                + "      <ChannelCode>3</ChannelCode>\n"
                + "      <BranchCode />\n"
                + "      <PayerName>UFORO UNWANA ENOBONG</PayerName>\n"
                + "      <PayerAccountNumber>0051762787</PayerAccountNumber>\n"
                + "      <Step>1</Step>\n"
                + "      <NextStep />\n"
                + "   </Header>\n"
                + "   <Record>\n"
                + "      <Name>referenceNumber</Name>\n"
                + "      <Value>1706238970</Value>\n"
                + "   </Record>\n"
                + "</CustomerInformationValidationRequest>";

        String gnldXML2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058170914155909376652621546</SessionId><BillerId>88</BillerId><ProductId>106</ProductId><FormId>235</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>referenceNumber</Name><Value>1612192700</Value></Record></CustomerInformationValidationRequest>";

        String notificationXML = "<NotificationRequest>\n"
                + "<BillerId>39</BillerId>\n"
                + "<TransactionId>999058170808101114126620634631</TransactionId>\n"
                + "<ClientCode>999058</ClientCode>\n"
                + "</NotificationRequest>";

        String bet9jaXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348397</SessionId><BillerId>87</BillerId><ProductId>107</ProductId><FormId>238</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>userId</Name><Value>23324</Value></Record><Record><Name>amount</Name><Value>100</Value></Record></CustomerInformationValidationRequest>";
        String jijiXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348489</SessionId><BillerId>96</BillerId><ProductId>121</ProductId><FormId>277</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>8</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>transactionReferenceCode</Name><Value>3098692809</Value></Record><Record><Name>amount</Name><Value>205</Value></Record></CustomerInformationValidationRequest>";
        String greenlightXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348489</SessionId><BillerId>72</BillerId><ProductId>89</ProductId><FormId>186</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>accountNumber</Name><Value>7937915</Value></Record><Record><Name>amount</Name><Value>100</Value></Record><Record><Name>phoneNumber</Name><Value>100</Value></Record></CustomerInformationValidationRequest>";
        String jambXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348947</SessionId><BillerId>102</BillerId><ProductId>136</ProductId><FormId>301</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>GSMNo</Name><Value>08159636027</Value></Record><Record><Name>token</Name><Value>1659855471</Value></Record></CustomerInformationValidationRequest>";

        String branchXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348947</SessionId><BillerId>124</BillerId><ProductId>174</ProductId><FormId>461</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>branchRegisteredMobileNumber</Name><Value>07034560055</Value></Record></CustomerInformationValidationRequest>";
        String elfriqueXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348947</SessionId><BillerId>170</BillerId><ProductId>245</ProductId><FormId>512</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>identificationCode</Name><Value>19</Value></Record><Record><Name>contestantNumber</Name><Value>1213</Value></Record><Record><Name>numberOfVotes</Name><Value>10</Value></Record></CustomerInformationValidationRequest>";
        String oneclickXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CustomerInformationValidationRequest><Header><SessionId>999058171017203120848774348947</SessionId><BillerId>166</BillerId><ProductId>241</ProductId><FormId>514</FormId><SourceBankCode>058</SourceBankCode><InstitutionCode>999070</InstitutionCode><ChannelCode>3</ChannelCode><BranchCode></BranchCode><PayerName>UFORO UNWANA ENOBONG</PayerName><PayerAccountNumber>0051762787</PayerAccountNumber><Step>1</Step><NextStep></NextStep></Header><Record><Name>amount</Name><Value>20</Value></Record><Record><Name>phoneNumber</Name><Value>08068891891</Value></Record><Record><Name>meterNumber</Name><Value>07131695012</Value></Record><Record><Name>disco</Name><Value>ABUJA</Value></Record><Record><Name>payerName</Name><Value>Ogechi</Value></Record></CustomerInformationValidationRequest>";

        //customer info test
        //validation test
        EBillsPayServiceUtil util = new EBillsPayServiceUtil(validationUrl);
        System.out.println("About sending request : " + oneclickXML);
        ValidationResponse valResp = util.doValidation("999999", oneclickXML);
        System.out.println("Validation Response : " + valResp.toString());
        //     String encryptedXml = crypto.encryptNIP("058", requestXML);
        //     String encryptedXml = "848C03650C95111FF705F90103FF5C48549ED882776A8591816CE3E2912A6EBC3F58F1A0BDE5E37C5DC19CE0F814ACF24091DF43260F5D9506BBCA76477298780B62EDBA4F49C081AF3B5ADB354BF3B10D6FE1FC049C9794C777ABFEB91E54C7EB60D87145741998311C8DA52026A5120BFAFE933DA414C53BE36367C04ECC4C2223A30EA7CDE42F5C3D4B0942EBC9C0768C64C4379AAA97A7E509B3A46940BDBD44AA4E1253E8869C62DC12E2CA465D54AD78D5D03FEBF314BA3FE52DEF6843A7ADBB7AD79C0670EE50A9DB81065C4295227AA1CACAB5D84C5F505E4A7AA70A1D0F242DAD47800812BBCC85BC4CC2B927E55AC1E58B498867F7F4C4E453B79CF30F6E94B36A09841BFA486EBA215E4AA98812F6E8FE5480FC18A31086AF8AE955BCF8A5C1D6F780043C1D7D8CC15BC88AA243B6BF83A12078686D0E00AC5BF103D49A60E28272EDF6D5757A25FB344CE0D6B6D0E74F2805B1FCD9D809DDC12C00E6D4E583EB448895738DCCE23B1D28B4390BBBF3FF708F4D9F4E721B3454CC72F574548AF05B5F7C208CC61F969C315FE80882F9D8301B5C5D1EAB2EC97A3611170B3B2D9094529160BE289949B245DBC3681F7A18A79C680602D22496437EC5CE84C1D0F143;";
        //notification test
//        EBillsPayServiceUtil util = new EBillsPayServiceUtil(notificationUrl);
//        System.out.println("About sending request : " + notificationXML);
//        String notificationResp = util.doNotification(notificationXML);
//        System.out.println("Notification Response : " + notificationResp);
        //   String response = util.sendRequest("999058", requestXML);
        //    String decryptedXml = crypto.decryptNIP("058", encryptedXml);
        //  System.out.println(response);
//        //  String response = util.sendRequest(crypto.encryptNIP("", requestXML));
        //  String response = util.sendRequest(crypto.encryptNIP("", requestXML));

        //              ICADRequestManager ussd = new ICADRequestManager();
        //              ArrayList bankList = ussd.connect2HostBVNBankUniqueList("22190950149");
    }

}
