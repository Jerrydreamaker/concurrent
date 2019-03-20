package com.iecas.concurrency.example.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10,
                1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>
                (10), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("reject");
            }
        });
        FutureTask<String> task=new FutureTask<String>(new CallableThread());
        executor.submit(task);
        System.out.println(task.get());
        executor.shutdown();

    }
}
