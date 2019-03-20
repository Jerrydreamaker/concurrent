package com.iecas.concurrency.example.overcome.callable.futuretask;

import com.iecas.concurrency.example.overcome.callable.future.FutureExample;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Do Something in Thread");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task=new FutureTask<String>(new FutureExample.MyCallable());
        ExecutorService service=Executors.newCachedThreadPool();
        Future future=service.submit(task);
        future.get();
        System.out.println("Do Something in TestCached");
        // 结果为 null
        //System.out.println("Result:"+future.get());
        System.out.println("Result:"+task.get());
        service.shutdown();
    }
}
