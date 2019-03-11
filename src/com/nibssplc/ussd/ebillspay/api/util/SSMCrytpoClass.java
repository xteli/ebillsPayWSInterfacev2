/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibssplc.ussd.ebillspay.api.util;

import com.nibss.nip.crypto.ws.NIPCryptoWSPortBindingStub;
import java.net.URL;
import javax.xml.rpc.Service;

/**
 *
 * @author hakintoye
 */
public class SSMCrytpoClass {

    NIPCryptoWSPortBindingStub stub;
    String url = "";
    Service service;

    public SSMCrytpoClass() {
//        try {
//            ServerConfig.LoadConfigParam();
//            URL url = new URL(ServerConfig.CPAYNIPCryptoURL());
//            stub = new NIPCryptoWSPortBindingStub(url, service);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public SSMCrytpoClass(String cryptoURL) {
        try {
     //       ServerConfig.LoadConfigParam();
            URL url = new URL(cryptoURL);
            stub = new NIPCryptoWSPortBindingStub(url, service);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String decryptNIP(String bankCode, String message) {
        String response = "";
        try {
            response = stub.decrypt(bankCode, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public String encryptNIP(String bankCode, String message) {
        String response = "";
        try {
            response = stub.encrypt(bankCode, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public String hashNIP(String bankCode, String message) {
        String response = "";
        try {
            response = stub.encrypt(bankCode, message);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
