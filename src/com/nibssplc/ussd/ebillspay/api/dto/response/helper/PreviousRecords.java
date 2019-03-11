/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author nibssops
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PreviousRecords {

    public PreviousRecords() {
    }

    @XmlElement(name = "customerID")
    private String customerID;
    @XmlElement(name = "Step")
    private Step[] step;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Step[] getStep() {
        return step;
    }

    public void setStep(Step[] step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "PreviousRecords{" + "customerID=" + customerID + ", step=" + step + '}';
    }

    

}
