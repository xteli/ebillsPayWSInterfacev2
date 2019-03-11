/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import com.nibssplc.ussd.ebillspay.api.dto.request.helper.ValidationRecord;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author nibssops
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

    @XmlElement(name = "Order")
    private String order;
    @XmlElement(name = "Record")
    private ValidationRecord[] validationRecord;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public ValidationRecord[] getValidationRecord() {
        return validationRecord;
    }

    public void setValidationRecord(ValidationRecord[] validationRecord) {
        this.validationRecord = validationRecord;
    }

    @Override
    public String toString() {
        return "Step{" + "order=" + order + ", validationRecord=" + validationRecord + '}';
    }
    
    

}
