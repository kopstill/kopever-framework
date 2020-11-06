package com.kopever.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * AES加密
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AESUtil {

    // 默认的AES加密方式：AES/ECB/PKCS5Padding
    private static final String AES = "AES";

    /**
     * 加密
     *
     * @param str 待加密明文
     * @param key 密钥(必须16/24/32位)
     * @return 加密密文
     */
    public static String encrypt(String str, String key) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);

            Cipher cipher = Cipher.getInstance(AES);
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
     * @param key 密钥(必须16/24/32位)
     * @return 解密明文
     */
    public static String decrypt(String str, String key) {
        try {
            byte[] bytes = Base64.getDecoder().decode(str);

            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES);

            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            bytes = cipher.doFinal(bytes);

            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
