/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response;

import com.nibssplc.ussd.ebillspay.api.dto.response.helper.ProductForm;
import com.nibssplc.ussd.ebillspay.api.dto.response.helper.PaymentDetail;
import com.nibssplc.ussd.ebillspay.api.dto.response.helper.PreviousRecords;
import com.nibssplc.ussd.ebillspay.api.dto.response.helper.ValidationResponseHeader;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author cojiteli
 */
@XmlRootElement(name = "CustomerInformationValidationResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValidationResponse implements Serializable {

    public ValidationResponse() {

    }

    @XmlElement(name = "Header")
    private ValidationResponseHeader validationHeader;
    @XmlElement(name = "PaymentDetail")
    private PaymentDetail paymentDetail;
    @XmlElement(name = "ProductForm")
    private ProductForm productForm;
    @XmlElement(name = "PreviousRecords")
    private PreviousRecords previousRecords;

    public ValidationResponseHeader getValidationHeader() {
        return validationHeader;
    }

    public void setValidationHeader(ValidationResponseHeader validationHeader) {
        this.validationHeader = validationHeader;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public ProductForm getProductForm() {
        return productForm;
    }

    public void setProductForm(ProductForm productForm) {
        this.productForm = productForm;
    }

    public PreviousRecords getPreviousRecords() {
        return previousRecords;
    }

    public void setPreviousRecords(PreviousRecords previousRecords) {
        this.previousRecords = previousRecords;
    }

    @Override
    public String toString() {
        return "ValidationResponse{" + "validationHeader=" + validationHeader + ", paymentDetail=" + paymentDetail + ", productForm=" + productForm + ", previousRecords=" + previousRecords + '}';
    }

}
