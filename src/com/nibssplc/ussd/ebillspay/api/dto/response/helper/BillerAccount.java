/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BillerAccount implements Serializable {

    public BillerAccount() {
    }

    @XmlElement(name = "AccountNumber")
    private String accountNumber;
    @XmlElement(name = "AccountName")
    private String accountName;
    @XmlElement(name = "InstitutionCode")
    private String institutionCode;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    @Override
    public String toString() {
        return "BillerAccount{" + "accountNumber=" + accountNumber + ", accountName=" + accountName + ", institutionCode=" + institutionCode + '}';
    }
    
    

}
