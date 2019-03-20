package com.iecas.concurrency.example.overcome.runnable.futuretask;

import javax.validation.constraints.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class RunnableFutureTaskSubmit {
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
        FutureTask<String> task=new FutureTask<String>(new MyRunnable(),"abc");
        //new Thread(task).start();
        ExecutorService service= Executors.newCachedThreadPool();
        service.submit(task);
        //阻塞等待，直到线程执行完成。
        System.out.println(task.get());
        service.shutdown();
    }
}
