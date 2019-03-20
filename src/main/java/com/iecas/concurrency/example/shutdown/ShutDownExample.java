package com.iecas.concurrency.example.shutdown;

import java.util.concurrent.*;

public class ShutDownExample {
    public static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(5000);
            System.out.println("Do Something in Thread");
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        Future<String> future=service.submit(new MyCallable());
        System.out.println("Do Something in Main");
        //service.shutdown();
        service.shutdownNow();
        System.out.println("Result:"+future.get());
    }
}
