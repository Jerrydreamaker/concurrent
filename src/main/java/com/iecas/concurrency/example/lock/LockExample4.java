package com.iecas.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * Condition 的使用。
 */
@Slf4j
public class LockExample4 {
    private static Lock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    public static void main(String[] args) {

        new Thread(()->{
            lock.lock();

            try {
                log.info("wait signal1");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal4");
            lock.unlock();


        }).start();

        new Thread(()->{
            lock.lock();
            log.info("get lock2");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal3");
            lock.unlock();
        }).start();
    }
}
