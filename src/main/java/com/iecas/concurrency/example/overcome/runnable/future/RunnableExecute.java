package com.iecas.concurrency.example.overcome.runnable.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * execute 方法提交 Runnable 接口实现类。
 */
public class RunnableExecute {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Do Something in Thread");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(new MyRunnable());
        service.shutdown();
    }
}
