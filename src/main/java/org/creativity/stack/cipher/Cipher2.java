package org.creativity.stack.cipher;

import org.bouncycastle.util.encoders.UTF8;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Cipher2 {

    public static String encrypt(final String secret, final String data) throws Exception {
        byte[] underscored = secret.getBytes(StandardCharsets.UTF_8);
        byte[] decodedKey = Base64.getUrlDecoder().decode(underscored);
        //byte[] decodedKey = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while encrypting data", e);
        }

    }

    public static String decrypt(final String secret,
                                 final String encryptedString) throws Exception{


        //byte[] decodedKey = Base64.getDecoder().decode(secret);
        byte[] decodedKey = Base64.getUrlDecoder().decode(secret.getBytes("UTF-8"));

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
    }


    public static void main(String[] args) throws Exception{

        String data = "This is not easy as you think";
        String key = "s_s";
        //String key = "abcedefg";
        String encrypted = encrypt(key, data);
        System.out.println(encrypted);
        System.out.println(decrypt(key, encrypted));
    }
}