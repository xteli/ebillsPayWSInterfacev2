/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationError {

    @XmlElement(name = "Param")
    private List<ErrorParamsXml> params;

    public ValidationError() {
    }

    public ValidationError(List<ErrorParamsXml> params) {
        super();
        this.params = params;
    }

    public List<ErrorParamsXml> getParams() {
        return params;
    }

    public void setParams(List<ErrorParamsXml> params) {
        this.params = params;
    }

}
