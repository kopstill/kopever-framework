package com.kopever.framework.test.temp;

import org.junit.Test;

public class TestVar {

    /**
     * About true, false and null: they represent certain values in Java, they are used as literals.
     * They are not considered as keywords.
     */
    @Test
    public void test() {
        boolean trueFlag = true;
        boolean falseFlag = false;
        System.out.println(trueFlag);
        System.out.println(falseFlag);
        System.out.println((Object) null);
    }

}
