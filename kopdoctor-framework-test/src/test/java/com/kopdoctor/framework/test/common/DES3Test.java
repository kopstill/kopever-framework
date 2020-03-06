package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.util.DES3Util;
import org.junit.Assert;
import org.junit.Test;

public class DES3Test {

    @Test
    public void testDES3() {
        String key = "#!f#mqp&hkefi@f#%qeznk@u";
        String str = "hello world";

        String encrypted = DES3Util.encrypt(str, key);
        System.out.println(encrypted);
        String decrypted = DES3Util.decrypt(encrypted, key);
        System.out.println(decrypted);

        Assert.assertEquals(str, decrypted);
    }

}
