package com.kopdoctor.framework.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESUtil {

    // 偏移量，必须16位
    private static final String DEFAULT_IV = "xz*#z#po$&stsjc*";

    private static final String AES = "AES";

    private static final String AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     *
     * @param str 解密字符串
     * @param key 密钥
     * @return 加密密文
     */
    public static String encrypt(String str, String key) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            IvParameterSpec ivParameterSpec = new IvParameterSpec(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);

            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            bytes = cipher.doFinal(bytes);
            bytes = Base64.getEncoder().encode(bytes);

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 解密
     *
     * @param str 解密字符串
     * @param key 密钥
     * @return 解密明文
     */
    public static String decrypt(String str, String key) {
        try {
            byte[] bytes = Base64.getDecoder().decode(str);

            IvParameterSpec ivParameterSpec = new IvParameterSpec(DEFAULT_IV.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);

            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            bytes = cipher.doFinal(bytes);

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
