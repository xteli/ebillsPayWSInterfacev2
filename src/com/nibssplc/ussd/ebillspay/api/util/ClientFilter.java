/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.util;

/**
 *
 * @author cojiteli
 */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

    private final String CLIENT_CODE;
    private final String CONTENT_TYPE;

    //  private final String CONTENT_TYPE;
//    public ClientFilter(String clientCode) {
//        this.CLIENT_CODE = clientCode;
//    }
//    
    public ClientFilter(String clientCode, String contentType) {
        this.CLIENT_CODE = clientCode;
        this.CONTENT_TYPE = contentType;
    }

    @Override
    public void filter(ClientRequestContext req) {
        req.getHeaders().remove("Accept");
        req.getHeaders().remove("Content-Type");
        req.getHeaders().add("clientCode", CLIENT_CODE);
        req.getHeaders().add("Accept", CONTENT_TYPE);
        req.getHeaders().add("Content-Type", CONTENT_TYPE);
        for (Map.Entry<String, List<Object>> entry : req.getHeaders().entrySet()) {
            System.out.println("entry = " + entry);
        }
        System.out.println("Added to HTTP Request Authorization [" + CLIENT_CODE + "]");
        System.out.println("Added to HTTP Request Authorization [" + CONTENT_TYPE + "]");
    }

    @Override
    public void filter(ClientRequestContext arg0, ClientResponseContext crc1)
            throws IOException {

        for (String key : crc1.getHeaders().keySet()) {
            System.out.println("Response Header: " + crc1.getHeaders().get(key));
        }

    }

}
