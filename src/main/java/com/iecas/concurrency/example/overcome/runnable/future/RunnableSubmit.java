package com.iecas.concurrency.example.overcome.runnable.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableSubmit {
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        Future future=service.submit(new MyRunnable(),"abc");
        System.out.println(future.get());
        //System.out.println(future.cancel(false));
        service.shutdown();
    }
}
