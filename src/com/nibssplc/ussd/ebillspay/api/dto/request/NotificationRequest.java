/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.request;

import com.nibssplc.ussd.ebillspay.api.dto.response.helper.NotificationObject;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cojiteli
 */
@XmlRootElement(name = "NotificationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationRequest implements Serializable{

    public NotificationRequest() {
    }

    @XmlElement(name = "ClientCode")
    private String clientCode;

    @XmlElement(name = "BillerId", required = true)
    private Long billerId;

    @XmlElement(name = "TransactionId", required = true)
    private String transactionId;

    public Long getBillerId() {
        return billerId;
    }

    public void setBillerId(Long billerId) {
        this.billerId = billerId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" + "clientCode=" + clientCode + ", billerId=" + billerId + ", transactionId=" + transactionId + '}';
    }

}
