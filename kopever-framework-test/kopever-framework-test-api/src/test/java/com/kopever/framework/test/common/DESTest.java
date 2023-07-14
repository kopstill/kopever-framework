package com.kopever.framework.test.common;

import com.kopever.framework.common.util.DESUtil;
import org.junit.Assert;
import org.junit.Test;

public class DESTest {

    @Test
    public void testDES() {
        String key = "ci^xkza!";
        String str = "hello world";

        String encrypted = DESUtil.encrypt(str, key);
        System.out.println(encrypted);
        String decrypted = DESUtil.decrypt(encrypted, key);
        System.out.println(decrypted);

        Assert.assertEquals(str, decrypted);
    }

}
