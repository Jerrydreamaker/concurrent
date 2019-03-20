package com.iecas.concurrency.example.overcome.runnable.start;

public class RunnableThread implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
