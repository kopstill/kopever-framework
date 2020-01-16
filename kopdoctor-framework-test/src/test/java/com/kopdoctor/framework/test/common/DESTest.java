package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.util.DESUtil;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class DESTest {

    public static final String DATA = "Ccs123456";

    @Test
    public void testDes() throws Exception {
        String key = "foreseedzswj_2017";
        byte[] desKey = key.getBytes();
        System.out.println("DES Key : " + Hex.encodeHexString(desKey));
        byte[] desReult = DESUtil.encryptDES(DATA.getBytes(), desKey);
        System.out.println(DATA + "DES 加密 =====>>>>>>> " + Hex.encodeHexString(desReult));
        byte[] plain = DESUtil.decryptDES(desReult, desKey);
        System.out.println(DATA + "DES 解密 =====>>>>>>> " + new String(plain));
    }

    public static String fromBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }

}
