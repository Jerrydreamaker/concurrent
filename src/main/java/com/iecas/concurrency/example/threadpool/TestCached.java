package com.iecas.concurrency.example.threadpool;

import com.iecas.concurrency.example.overcome.runnable.start.RunnableThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCached {
    public static void main(String[] args) {
        //new RunnableThread().start();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(new RunnableThread());
        executorService.shutdown();
    }
}
