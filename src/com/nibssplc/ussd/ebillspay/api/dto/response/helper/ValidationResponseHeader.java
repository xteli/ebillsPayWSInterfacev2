/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import com.nibssplc.ussd.ebillspay.api.dto.request.helper.ValidationRequestHeader;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationResponseHeader extends ValidationRequestHeader {

    public ValidationResponseHeader() {
    }

    @XmlElement(name = "ResponseCode")
    private String responseCode;
    @XmlElement(name = "ResponseMessage")
    private String responseMessage;
    @XmlElement(name = "ErrorMessages")
    private ValidationError errorMessages = null;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ValidationError getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(ValidationError errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "ValidationResponseHeader{" + "responseCode=" + responseCode + ", responseMessage=" + responseMessage + '}';
    }

}
