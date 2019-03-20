package com.iecas.concurrency.example.overcome.runnable;



/**
 * 测试实现 Runnable 接口的线程如果非线程池方式启动。
 */
public class RunnableStartTest {
    public static void main(String[] args) {
        new Thread(new RunnableThread()).start();
    }
}
