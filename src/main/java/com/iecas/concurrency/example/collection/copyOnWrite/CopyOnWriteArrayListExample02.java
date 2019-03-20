package com.iecas.concurrency.example.collection.copyOnWrite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample02 {

    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                list.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}

