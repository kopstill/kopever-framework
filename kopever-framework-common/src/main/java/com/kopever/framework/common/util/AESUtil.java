package com.kopever.framework.common.util;

import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    private static final String AES_CIPHER = "AES/CBC/PKCS5PADDING";

    private static final String AES_ALGORITHM = "AES";

    private static final String AES_ENCODING = "UTF-8";

    public static String encrypt(String value, String secret, String vector) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(AES_ENCODING), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(AES_ENCODING));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        return DatatypeConverter.printBase64Binary(cipher.doFinal(value.getBytes(AES_ENCODING)));
    }

    public static String decrypt(String encrypted, String secret, String vector) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(AES_ENCODING), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(AES_ENCODING));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        return new String(cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted)), AES_ENCODING);
    }

}
