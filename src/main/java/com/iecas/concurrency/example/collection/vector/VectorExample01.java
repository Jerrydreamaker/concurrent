package com.iecas.concurrency.example.collection.vector;

import java.util.List;
import java.util.Vector;

public class VectorExample01 {
    private static List<Integer> list=new Vector<>();
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            list.add(i);
        }
        Thread thread1=new Thread(){

            @Override
            public void run() {
                for (int i=0;i<list.size();i++){
                    list.get(i);
                }
            }
        };

        Thread thread2=new Thread(){

            @Override
            public void run() {
                for (int i=0;i<list.size();i++){
                    list.remove(i);
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}
