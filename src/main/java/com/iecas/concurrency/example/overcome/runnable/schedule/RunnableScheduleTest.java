package com.iecas.concurrency.example.overcome.runnable.schedule;

import com.iecas.concurrency.example.overcome.runnable.start.RunnableThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunnableScheduleTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(10);
        executorService.schedule(new RunnableThread(),3, TimeUnit.SECONDS);
        //executorService
        executorService.shutdown();
    }
}
