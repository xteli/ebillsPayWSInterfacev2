/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.request;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cojiteli
 */
@XmlRootElement(name = "PaymentChannelReceipt")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentReceiptRequest implements Serializable {

    @XmlElement(name = "SessionID")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "PaymentReceiptRequest{" + "sessionId=" + sessionId + '}';
    }

}
