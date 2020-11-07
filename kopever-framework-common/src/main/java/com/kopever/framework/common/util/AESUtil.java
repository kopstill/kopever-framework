package com.kopever.framework.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESUtil {

    private static final String AES_CIPHER = "AES/CBC/PKCS5PADDING";

    private static final String AES_ALGORITHM = "AES";

    private static final String AES_ENCODING = "UTF-8";

    public static String encrypt(String value, String secret, String vector) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(AES_ENCODING), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(AES_ENCODING));

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(value.getBytes(AES_ENCODING));

        return DatatypeConverter.printBase64Binary(encrypted);
    }

    public static String decrypt(String encrypted, String secret, String vector) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_CIPHER);
        SecretKeySpec skeySpec = new SecretKeySpec(secret.getBytes(AES_ENCODING), AES_ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes(AES_ENCODING));

        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

        byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));

        return new String(original, AES_ENCODING);
    }

}
