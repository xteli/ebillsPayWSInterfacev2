/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author cojiteli
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class FormField implements Serializable {

    public FormField() {
    }

    @XmlElement(name = "Label")
    private String label;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Type")
    private String type;
    @XmlElement(name = "DefaultValue")
    private String defaultValue;
    @XmlElement(name = "MaxLength")
    private String maxLength;
    @XmlElement(name = "Required")
    private String required;
    @XmlElement(name = "Readonly")
    private String readonly;
    @XmlElement(name="Item")
    private List<ItemXml> listItem = new ArrayList<ItemXml>();
    @XmlElement(name = "Order")
    private String order;
    @XmlElement(name = "RequiredInNextStep")
    private String requiredInNextStep;
    @XmlElement(name = "AmountField")
    private String amountField;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getReadonly() {
        return readonly;
    }

    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRequiredInNextStep() {
        return requiredInNextStep;
    }

    public void setRequiredInNextStep(String requiredInNextStep) {
        this.requiredInNextStep = requiredInNextStep;
    }

    public String getAmountField() {
        return amountField;
    }

    public void setAmountField(String amountField) {
        this.amountField = amountField;
    }

    public List<ItemXml> getListItem() {
        return listItem;
    }

    public void setListItem(List<ItemXml> listItem) {
        this.listItem = listItem;
    }

    @Override
    public String toString() {
        return "FormField{" + "label=" + label + ", name=" + name + ", type=" + type + ", defaultValue=" + defaultValue + ", maxLength=" + maxLength + ", required=" + required + ", readonly=" + readonly + ", listItem=" + listItem + ", order=" + order + ", requiredInNextStep=" + requiredInNextStep + ", amountField=" + amountField + '}';
    }
    

}
