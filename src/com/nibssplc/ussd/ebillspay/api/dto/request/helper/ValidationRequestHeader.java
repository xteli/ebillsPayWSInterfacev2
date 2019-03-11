/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.request.helper;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationRequestHeader implements Serializable {

    public ValidationRequestHeader() {
    }

    @XmlElement(name = "SessionId")
    private String sessionId;
    @XmlElement(name = "BillerId")
    private String billerId;
    @XmlElement(name = "ProductId")
    private String productId;
    @XmlElement(name = "FormId")
    private String formId;
    @XmlElement(name = "SourceBankCode")
    private String sourceBankCode;
    @XmlElement(name = "InstitutionCode")
    private String institutionCode;
    @XmlElement(name = "ChannelCode")
    private String channelCode;
    @XmlElement(name = "BranchCode")
    private String branchCode;
    @XmlElement(name = "PayerName")
    private String payerName;
    @XmlElement(name = "PayerAccountNumber")
    private String payerAccountNumber;
    @XmlElement(name = "Step")
    private String step;
    @XmlElement(name = "NextStep")
    private String nextStep;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getSourceBankCode() {
        return sourceBankCode;
    }

    public void setSourceBankCode(String sourceBankCode) {
        this.sourceBankCode = sourceBankCode;
    }
    
    

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    @Override
    public String toString() {
        return "ValidationRequestHeader{" + "sessionId=" + sessionId + ", billerId=" + billerId + ", productId=" + productId + ", formId=" + formId + ", sourceBankCode=" + sourceBankCode + ", institutionCode=" + institutionCode + ", channelCode=" + channelCode + ", branchCode=" + branchCode + ", payerName=" + payerName + ", payerAccountNumber=" + payerAccountNumber + ", step=" + step + ", nextStep=" + nextStep + '}';
    }
    
    

}
