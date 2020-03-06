package com.kopdoctor.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * DES加密
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DESUtil {

    // 默认的DES加密方式：DES/ECB/PKCS5Padding
    private static final String DES = "DES";

    /**
     * 加密
     *
     * @param str 待加密明文
     * @param key 密钥(必须8位)
     * @return 加密密文
     */
    public static String encrypt(String str, String key) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), DES);

            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
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
     * @param str 待解密密文
     * @param key 密钥(必须8位)
     * @return 解密明文
     */
    public static String decrypt(String str, String key) {
        try {
            byte[] bytes = Base64.getDecoder().decode(str);

            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), DES);

            Cipher cipher = Cipher.getInstance(DES);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            bytes = cipher.doFinal(bytes);

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
