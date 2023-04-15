package com.kopever.framework.test.temp;

import org.junit.Test;

public class XORTest {

    @Test
    public void testXOR() {
        System.out.println(135 ^ 135);
        System.out.println(658 ^ 0);
        System.out.println(0 ^ 658);
        System.out.println(1 ^ 2);
        System.out.println(1 ^ 2 ^ 1);
        System.out.println(100 ^ 200);
        System.out.println(100 ^ 200 ^ 100);
    }

}
