package com.nibssplc.ussd.ebillspay.api.dto.response.helper;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class ItemXml implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6314981595699995923L;
	@XmlElement(name="Label")
	private String label;
	@XmlElement(name="Value")
	private String value;
	
	public ItemXml() {}
	
	public ItemXml(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
