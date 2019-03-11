/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
public class NotificationObject implements Serializable {

    public NotificationObject() {
    }

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

}
