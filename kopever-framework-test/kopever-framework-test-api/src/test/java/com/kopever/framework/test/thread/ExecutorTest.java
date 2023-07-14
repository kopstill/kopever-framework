package com.kopever.framework.test.thread;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    @Test
    public void testExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new TempTask(0));
        Assert.assertEquals(1, Thread.currentThread().getId());
    }

    private static class TempTask extends Thread {

        private final int i;

        private TempTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(this.getName() + "=" + i);
        }
    }

}
