package com.kopdoctor.framework.common.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RsaUtil {

    private static final String ALGORITHM = "RSA";
    private static final String SHA256WITHRSA = "SHA256withRSA";
    private static final String SHA1WITHRSA = "SHA1WithRSA";
    private static final int KEY_SIZE = 1024;
    private static final String ENCODING = "UTF-8";

    /**
     * 产出密钥对
     */
    public static KeyPair initKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        return keyPairGenerator.generateKeyPair();
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
     * 产出公钥对象
     */
    public static PublicKey toPublicKey(byte[] publicKeyByte) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyByte));
    }

    /**
     * 产出公钥对象
     */
    public static PublicKey toPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
    }

    /**
     * 产出私钥对象
     */
    public static PrivateKey toPrivateKey(byte[] privateKeyByte) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyByte));
    }

    /**
     * 产出私钥对象
     */
    public static PrivateKey toPrivateKey(String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
    }

    /**
     * 私钥签名
     */
    public static byte[] signSHA256(String content, byte[] privateKeyByte) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        PrivateKey priKey = toPrivateKey(privateKeyByte);

        Signature signature = Signature.getInstance(SHA256WITHRSA);
        signature.initSign(priKey);
        signature.update(content.getBytes(ENCODING));

        return signature.sign();
    }

    /**
     * 私钥签名
     */
    public static String signSHA256(String content, String privateKey) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        return sign(content, privateKey, SHA256WITHRSA);
    }

    /**
     * 私钥签名
     */
    public static String signSHA1(String content, String privateKey) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        return sign(content, privateKey, SHA1WITHRSA);
    }

    /**
     * 签名
     */
    private static String sign(String content, String privateKey, String algorithm) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        PrivateKey priKey = toPrivateKey(privateKey);

        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(priKey);
        signature.update(content.getBytes(ENCODING));

        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * 公钥验签
     */
    public static boolean verifySignSHA256(String content, byte[] publicKeyByte, byte[] sign) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        PublicKey pubKey = toPublicKey(publicKeyByte);

        Signature signature = Signature.getInstance(SHA256WITHRSA);
        signature.initVerify(pubKey);
        signature.update(content.getBytes(ENCODING));

        return signature.verify(sign);
    }

    /**
     * 公钥验签
     */
    public static boolean verifySignSHA256(String content, String publicKey, String sign) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        return verifySign(content, publicKey, sign, SHA256WITHRSA);
    }

    /**
     * 公钥验签
     */
    public static boolean verifySignSHA1(String content, String publicKey, String sign) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        return verifySign(content, publicKey, sign, SHA1WITHRSA);
    }

    /**
     * 验签
     */
    private static boolean verifySign(String content, String publicKey, String sign, String algorithm) throws
            InvalidKeySpecException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            UnsupportedEncodingException,
            SignatureException {
        PublicKey pubKey = toPublicKey(publicKey);

        Signature signature = Signature.getInstance(algorithm);
        signature.initVerify(pubKey);
        signature.update(content.getBytes(ENCODING));

        return signature.verify(Base64.getDecoder().decode(sign));
    }

    /**
     * 公钥加密
     */
    public static String encrypt(String content, String publicKey) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, toPublicKey(publicKey));
        return Base64.getEncoder().encodeToString(cipher.doFinal(content.getBytes(ENCODING)));
    }

    /**
     * 私钥解密
     */
    public static String decrypt(String content, String privateKey) throws
            NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeySpecException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, toPrivateKey(privateKey));
        byte[] buf = Base64.getDecoder().decode(content);
        return new String(cipher.doFinal(buf), ENCODING);
    }

}
