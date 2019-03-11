/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nibssplc.ussd.ebillspay.api.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hakintoye
 */
public class ServerConfig {
    private static String db_ip;
    private static String db_port;
    private static String db_name;
    private static String db_username;
    private static String db_password;
    private static String c_masked;
    private static String cs_email;
    private static String acv_upload_path;
    
    private static String cpay_nibss_public;
    private static String cpay_nibss_private;
    private static String cpay_nip_crypto_url;
    private static String cpay_nip_url;
    
    private static String cpay_host_ip;
    
    public ServerConfig(){

    }
    public static String DBIp(){
        return db_ip;
    }
    public static String DBPort(){
        return db_port;
    }
    public static String DBName(){
        return db_name;
    }
    public static String DBUsername(){
        return db_username;
    }
    public static String DBPassword(){
        return db_password;
    }
    public static String DBmasked() {
        return c_masked;
    }
    public static String CSEmail() {
        return cs_email;
    }
    public static String ASVUploadPath() {
        return acv_upload_path;
    }
    public static String CPAYNIBSSPublic() {
        return cpay_nibss_public;
    }
    public static String CPAYNIBSSPrivate() {
        return cpay_nibss_private;
    }
    public static String CPAYNIPCryptoURL() {
        return cpay_nip_crypto_url;
    }
    public static String CPAYNIPURL() {
        return cpay_nip_url;
    }
    
    public static String CPAYHostIP() {
        return cpay_host_ip;
    }
    public static void LoadConfigParam() throws FileNotFoundException, IOException{
        String param_name = null;
        String param_val = null;
        java.text.SimpleDateFormat errordateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date errordate = new java.util.Date();

         try {
            FileReader fr = new FileReader("C:\\APPConfig\\conf\\dbparam_cpayplus.ini");
            BufferedReader b_rdr = new BufferedReader(fr);
            while ((param_name = b_rdr.readLine()) != null)
            {
                if (param_name.indexOf("=") > 0) {

                    param_val = param_name.substring(param_name.indexOf("=") + 1, param_name.length()).trim();
                    param_name = param_name.substring(0, param_name.indexOf("=")).trim();

                    if (param_name.equals("db_ip")) {
                        db_ip = param_val;
                    }
                    else if (param_name.equals("db_port"))
                    {
                        db_port = param_val;
                    }
                    else if (param_name.equals("db_name"))
                    {
                        db_name = param_val;
                    }
                    else if (param_name.equals("db_username"))
                    {
                        db_username = param_val;
                    }
                    else if (param_name.equals("db_password"))
                    {
                        db_password = param_val;
                    }
                    else if (param_name.equals("db_masked"))
                    {
                        c_masked = param_val;
                    }
                    else if (param_name.equals("cs_email"))
                    {
                        cs_email = param_val;
                    }
                    else if (param_name.equals("acv_upload_path"))
                    {
                        acv_upload_path = param_val;
                    }
                    else if (param_name.equals("cpay_nibss_public"))
                    {
                        cpay_nibss_public = param_val;
                    }
                    else if (param_name.equals("cpay_nibss_private"))
                    {
                        cpay_nibss_private = param_val;
                    }
                    else if (param_name.equals("cpay_nip_crypto_url"))
                    {
                        cpay_nip_crypto_url = param_val;
                    }
                    else if (param_name.equals("cpay_nip_url"))
                    {
                        cpay_nip_url = param_val;
                    }
                    else if (param_name.equals("cpay_host_ip"))
                    {
                        cpay_host_ip = param_val;
                    }
                }
            }
         } catch (Exception e) {
            System.out.println("::Error occured reading parameters:::"+e.toString());
            e.printStackTrace();
        }
    }
   
}