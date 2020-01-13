package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.core.id.SnowflakeIdWorker;
import org.junit.Assert;
import org.junit.Test;

public class IdGeneratorTest {

    @Test
    public void testSnowflakeIdGenerator() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }

        Assert.assertTrue(true);
    }

}
