package com.iecas.concurrency.example.automic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class CountExample1 {
    private static int clientTotal=5000;
    private static int threadTotal=200;
    private static int count=0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService excutorService= Executors.newCachedThreadPool();//使用线程池。
        final Semaphore semaphore=new Semaphore(threadTotal);//实现信号量限制并发线程数，使用countDownLatch让主线程等待辅线程执行完毕。
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for (int i=0;i<clientTotal;i++){
            excutorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        excutorService.shutdown();//强行shutdown加快程序执行。
        log.info("count:{}"+count);
    }

    public static void add(){
        count++;
    }
}
