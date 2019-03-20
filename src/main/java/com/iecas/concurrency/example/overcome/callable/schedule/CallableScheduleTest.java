package com.iecas.concurrency.example.overcome.callable.schedule;


import java.util.concurrent.*;

public class CallableScheduleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(10);
        ScheduledFuture<String> future=executorService.schedule(new CallableThread(),3, TimeUnit.SECONDS);
        //executorService
        System.out.println(future.get());
        executorService.shutdown();
    }
}
