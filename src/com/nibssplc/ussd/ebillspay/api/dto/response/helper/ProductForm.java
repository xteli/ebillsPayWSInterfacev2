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
public class ProductForm {

    public ProductForm() {
    }

    @XmlElement(name = "Step")
    private String step;
    @XmlElement(name = "FormId")
    private String formId;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Enabled")
    private String enabled;
    @XmlElement(name = "FormField")
    private List<FormField> formField;
    @XmlElement(name = "errorMessage")
    private String errorMessage;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public List<FormField> getFormField() {
        return formField;
    }

    public void setFormField(List<FormField> formField) {
        this.formField = formField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ProductForm{" + "step=" + step + ", formId=" + formId + ", title=" + title + ", enabled=" + enabled + ", formField=" + formField + '}';
    }

}
