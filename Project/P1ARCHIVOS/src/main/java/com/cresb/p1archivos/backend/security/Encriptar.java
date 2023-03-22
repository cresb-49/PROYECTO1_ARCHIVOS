package com.cresb.p1archivos.backend.security;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Dango
 */
public class Encriptar {
    public static String encriptar(String password){
        return DigestUtils.md5Hex(password);
    }
}
