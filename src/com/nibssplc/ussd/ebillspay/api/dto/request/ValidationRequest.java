/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.request;

import com.nibssplc.ussd.ebillspay.api.dto.request.helper.ValidationRecord;
import com.nibssplc.ussd.ebillspay.api.dto.request.helper.ValidationRequestHeader;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cojiteli
 */
@XmlRootElement(name = "CustomerInformationValidationRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationRequest implements Serializable {

    public ValidationRequest() {

    }

    @XmlElement(name = "Header")
    private ValidationRequestHeader validationHeader;
    @XmlElement(name = "Record")
    private ValidationRecord[] validationRecord;
    
    
    public ValidationRequestHeader getValidationHeader() {
        return validationHeader;
    }

    public void setValidationHeader(ValidationRequestHeader validationHeader) {
        this.validationHeader = validationHeader;
    }

    public ValidationRecord[] getValidationRecord() {
        return validationRecord;
    }

    public void setValidationRecord(ValidationRecord[] validationRecord) {
        this.validationRecord = validationRecord;
    }

  
}
