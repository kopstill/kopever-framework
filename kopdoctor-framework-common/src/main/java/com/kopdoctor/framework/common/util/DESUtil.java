package com.kopdoctor.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DESUtil {

    // 偏移量，必须8位
    private static final String DEFAULT_IV = "c$rb*r!w";

    private static final String DES = "DES";

    private static final String DES_CBC_PKCS5PADDING = "DES/CBC/PKCS5Padding";

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
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), DES);

            Cipher cipher = Cipher.getInstance(DES_CBC_PKCS5PADDING);
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
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), DES);

            Cipher cipher = Cipher.getInstance(DES_CBC_PKCS5PADDING);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            bytes = cipher.doFinal(bytes);

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
