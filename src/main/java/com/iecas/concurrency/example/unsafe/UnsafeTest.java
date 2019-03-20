package com.iecas.concurrency.example.unsafe;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeTest {
    private static Unsafe test=Unsafe.getUnsafe();

    private static AtomicInteger a=new AtomicInteger(0);
    public static void main(String[] args) {
        System.out.println(a.incrementAndGet());
        //System.out.println(test.getAndAddInt(a,));
    }
}
