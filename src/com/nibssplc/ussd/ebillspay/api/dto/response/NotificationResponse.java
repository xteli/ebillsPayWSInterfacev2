/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response;

import com.nibssplc.ussd.ebillspay.api.dto.response.helper.NotificationObject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cojiteli
 */
@XmlRootElement(name = "NotificationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class NotificationResponse  {

    public NotificationResponse() {
    }

    @XmlElement(name = "Message")
    private String message;
    @XmlElement(name = "ResponseCode")
    private String responseCode;
    @XmlElement(name = "NotificationResponse")
    private String notificationResponse;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getNotificationResponse() {
        return notificationResponse;
    }

    public void setNotificationResponse(String notificationResponse) {
        this.notificationResponse = notificationResponse;
    }

    @Override
    public String toString() {
        return "NotificationResponse{" + "message=" + message + ", responseCode=" + responseCode + ", notificationResponse=" + notificationResponse + '}';
    }

}
