package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.util.AESUtil;
import org.junit.Assert;
import org.junit.Test;

public class AESTest {

    @Test
    public void testAES() {
        String key = "h&flvrczvd$pkj*dmkwuk@z#rprfeww@";
        String str = "hello world";

        String encrypted = AESUtil.encrypt(str, key);
        System.out.println(encrypted);
        String decrypted = AESUtil.decrypt(encrypted, key);
        System.out.println(decrypted);

        Assert.assertEquals(str, decrypted);
    }

}
