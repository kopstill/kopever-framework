package com.kopever.framework.test.common;

import com.kopever.framework.common.util.AESUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESTest {

    @Test
    public void testAES() throws NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        String secret = "h&flvrczvd$pkj*d";
        String vector = "mkwuk@z#rprfeww@";
        String str = "hello world";

        String encrypted = AESUtil.encrypt(str, secret, vector);
        System.out.println(encrypted);
        String decrypted = AESUtil.decrypt(encrypted, secret, vector);
        System.out.println(decrypted);

        Assert.assertEquals(str, decrypted);
    }

}
