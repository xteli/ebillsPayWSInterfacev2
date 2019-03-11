/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDetail implements Serializable {

    public PaymentDetail() {
    }

    @XmlElement(name = "TransactionId")
    private String transactionId;
    @XmlElement(name = "BillerAccount")
    private BillerAccount billerAccount;
    @XmlElement(name = "Amount")
    private String amount;
    @XmlElement(name = "PaymentFee")
    private String transactionFee;
    @XmlElement(name = "PaymentReference")
    private String paymentReference;
    @XmlElement(name = "TotalAmount")
    private String totalAmount;
    @XmlElement(name = "BillerName")
    private String billerName;
    @XmlElement(name = "ProductName")
    private String productName;
    @XmlElement(name = "NotificationResponse")
    private String notificationResponse;
    @XmlElement(name = "PaymentType")
    private String paymentType = "1";
    @XmlElement(name = "CustomerName")
    private String customerName;
    @XmlElement(name = "CustomerAccountNumber")
    private String customerAccountNumber;
    @XmlElement(name = "TransactionDate")
    private Date transactionDate;
    @XmlElement(name = "Param")
    private List<UserParam> userParams = null;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(String transactionFee) {
        this.transactionFee = transactionFee;
    }

    public BillerAccount getBillerAccount() {
        return billerAccount;
    }

    public void setBillerAccount(BillerAccount billerAccount) {
        this.billerAccount = billerAccount;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getBillerName() {
        return billerName;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNotificationResponse() {
        return notificationResponse;
    }

    public void setNotificationResponse(String notificationResponse) {
        this.notificationResponse = notificationResponse;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public List<UserParam> getUserParams() {
        return userParams;
    }

    public void setUserParams(List<UserParam> userParams) {
        this.userParams = userParams;
    }

    @Override
    public String toString() {
        return "PaymentDetail{" + "transactionId=" + transactionId + ", billerAccount=" + billerAccount + ", amount=" + amount + ", transactionFee=" + transactionFee + ", paymentReference=" + paymentReference + ", totalAmount=" + totalAmount + ", billerName=" + billerName + ", productName=" + productName + ", notificationResponse=" + notificationResponse + ", paymentType=" + paymentType + ", customerName=" + customerName + ", customerAccountNumber=" + customerAccountNumber + ", transactionDate=" + transactionDate + ", userParams=" + userParams + '}';
    }
    
    

    

}
