package com.kopdoctor.framework.test.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    @Test
    public void testOOM() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int i = 0;
        while (true) {
            executorService.execute(new TempTask(i++));
        }
    }

    private static class TempTask extends Thread {

        private int i;

        private TempTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(this.getName() + "=" + i);
        }
    }

}
