package com.kopever.framework.test.common;

import com.kopever.framework.common.util.RSAUtil;
import org.junit.Assert;
import org.junit.Test;

import java.security.KeyPair;

public class RSATest {

    @Test
    public void testRSA() throws Exception {
        KeyPair keyPair = RSAUtil.initKey();
        String publicKey = RSAUtil.getPublicKey(keyPair.getPublic());
        String privateKey = RSAUtil.getPrivateKey(keyPair.getPrivate());
        System.out.println("Public key: " + publicKey);
        System.out.println("Private key: " + privateKey);

        String content = "You'll never walk alone";

        String sha1Sign = RSAUtil.signSHA1(content, privateKey);
        System.out.println("SHA1 sign: " + sha1Sign);
        Assert.assertTrue(RSAUtil.verifySignSHA1(content, publicKey, sha1Sign));

        String sha256Sign = RSAUtil.signSHA256(content, privateKey);
        System.out.println("SHA256 sign: " + sha256Sign);
        Assert.assertTrue(RSAUtil.verifySignSHA256(content, publicKey, sha256Sign));

        String encrypt = RSAUtil.encrypt(content, publicKey);
        System.out.println("Encrypt: " + encrypt);
        String decrypt = RSAUtil.decrypt(encrypt, privateKey);
        System.out.println("Decrypt: " + decrypt);
    }

}
