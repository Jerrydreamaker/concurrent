package com.iecas.concurrency.example.threadpool;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Do Something in Thread");
        Thread.sleep(5000);
        return "Done";
    }
}
