package com.mehdilagdimi.marocair_api.util.Security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class  HashUtil {

    public static String hashPassword(String passw){
        String base64encodedPassword = Base64.getEncoder().encodeToString(generatePBKDF2(passw));
        return  base64encodedPassword;
    }

    public static byte[] generatePBKDF2(String passw){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        SecretKeyFactory factory;
        byte[] hash = null;

        try{
            KeySpec spec = new PBEKeySpec(passw.toCharArray(), salt, 65536, 128);
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e){
            e.printStackTrace();
        }
        return hash;
    }
}
