/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 *
 * @author cojiteli
 * @param <T>
 */
 class Parser<T> {

    private final Class<T> entityClass;

    Parser(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * @param entity
     * @return
     * @throws IOException
     * @throws JAXBException
     * @throws Exception
     */
    public String convertObjectToXMLString(T entity) throws IOException, JAXBException, Exception {
        String xmlObject = "";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JAXBContext jc = JAXBContext.newInstance(entityClass);
        Marshaller marshaller = jc.createMarshaller();
        //  marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(entity, outputStream);
        xmlObject = outputStream.toString();
        return xmlObject;
    }

    /**
     *
     * @param xmlString
     * @return
     * @throws IOException
     * @throws JAXBException
     * @throws Exception
     */
    public T convertXMLStringToObject(String xmlString) throws IOException, JAXBException, Exception {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
        JAXBContext jc = JAXBContext.newInstance(entityClass);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        T entity = (T) unmarshaller.unmarshal(inputStream);
        return entity;
    }

 
}
