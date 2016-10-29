/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author REGISTRO
 */
public class MiHash
{
    public static String getHash(String cadena)
    {
        byte[] digest = null;
        byte[] buffer = cadena.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Hash");
        }
        return toHexadecimal(digest);
    }
    
    private static String toHexadecimal(byte[] digest)
    {
        String hash = "";
        for(byte aux : digest)
        {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
                 hash += Integer.toHexString(b);
        }
        return hash;
    }
}
