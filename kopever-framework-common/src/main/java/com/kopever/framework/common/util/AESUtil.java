package com.kopever.framework.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESUtil {

    private static final String AES_CIPHER = "AES/CBC/PKCS5PADDING";

    private static final String AES_ALGORITHM = "AES";

    public static String encrypt(String value, String secret, String vector) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decrypt(String encrypted, String secret, String vector) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)), StandardCharsets.UTF_8);
    }

}
