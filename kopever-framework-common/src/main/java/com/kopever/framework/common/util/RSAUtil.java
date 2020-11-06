package com.kopever.framework.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RSAUtil {

    private static final int KEY_SIZE = 4096;
    private static final String ALGORITHM = "RSA";
    private static final String SHA1WITHRSA = "SHA1WithRSA";
    private static final String SHA256WITHRSA = "SHA256withRSA";

    /**
     * 产出密钥对
     */
    public static KeyPair initKey() throws NoSuchAlgorithmException {
        return initKey(KEY_SIZE);
    }

    /**
     * 产出密钥对
     */
    public static KeyPair initKey(int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 转换为公钥字符串
     */
    public static String getPublicKey(PublicKey publicKey) {
        return new String(Base64.getEncoder().encode(publicKey.getEncoded()), StandardCharsets.UTF_8);
    }

    /**
     * 产出公钥对象
     */
    public static PublicKey toPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return toPublicKey(Base64.getDecoder().decode(publicKey));
    }

    /**
     * 产出公钥对象
     */
    private static PublicKey toPublicKey(byte[] publicKeyByte) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyByte));
    }

    /**
     * 转换为私钥字符串
     */
    public static String getPrivateKey(PrivateKey privateKey) {
        return new String(Base64.getEncoder().encode(privateKey.getEncoded()), StandardCharsets.UTF_8);
    }

    /**
     * 产出私钥对象
     */
    public static PrivateKey toPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return toPrivateKey(Base64.getDecoder().decode(privateKey));
    }

    /**
     * 产出私钥对象
     */
    private static PrivateKey toPrivateKey(byte[] privateKeyByte) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyByte));
    }

    /**
     * 私钥签名
     */
    public static String signSHA1(String content, String privateKey) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        return sign(content, privateKey, SHA1WITHRSA);
    }

    /**
     * 私钥签名
     */
    public static String signSHA256(String content, String privateKey) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        return sign(content, privateKey, SHA256WITHRSA);
    }

    /**
     * 签名
     */
    private static String sign(String content, String privateKey, String algorithm) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        PrivateKey priKey = toPrivateKey(privateKey);

        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(priKey);
        signature.update(content.getBytes(StandardCharsets.UTF_8));

        return new String(Base64.getEncoder().encode(signature.sign()), StandardCharsets.UTF_8);
    }

    /**
     * 公钥验签
     */
    public static boolean verifySignSHA1(String content, String publicKey, String sign) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        return verifySign(content, publicKey, sign, SHA1WITHRSA);
    }

    /**
     * 公钥验签
     */
    public static boolean verifySignSHA256(String content, String publicKey, String sign) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        return verifySign(content, publicKey, sign, SHA256WITHRSA);
    }

    /**
     * 验签
     */
    private static boolean verifySign(String content, String publicKey, String sign, String algorithm) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            SignatureException {
        PublicKey pubKey = toPublicKey(publicKey);

        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(pubKey);
        signature.update(content.getBytes(StandardCharsets.UTF_8));

        return signature.verify(Base64.getDecoder().decode(sign));
    }

    /**
     * 公钥加密
     */
    public static String encrypt(String plainText, String publicKey) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, toPublicKey(publicKey));
        return new String(Base64.getEncoder().encode(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
    }

    /**
     * 私钥解密
     */
    public static String decrypt(String cipherText, String privateKey) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, toPrivateKey(privateKey));
        return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)), StandardCharsets.UTF_8);
    }

}
