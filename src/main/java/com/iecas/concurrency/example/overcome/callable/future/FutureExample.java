package com.iecas.concurrency.example.overcome.callable.future;

import java.util.concurrent.*;

public class FutureExample {
    public static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("Do Something in Thread");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        Future<String> future=service.submit(new MyCallable());
        System.out.println("Do Something in TestCached");
        System.out.println("Result:"+future.get());
    }
}
