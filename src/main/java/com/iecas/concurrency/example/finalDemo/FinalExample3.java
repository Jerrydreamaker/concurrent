package com.iecas.concurrency.example.finalDemo;

import java.util.HashMap;
import java.util.Map;

public class FinalExample3 {
    private final static  int a=2;
    private final static  String b="wlj";
    private final static Map<Integer,Integer> map=new HashMap<>();

    public void test(final int a){
        //非法操作。
        //a=1;

    }
    public static void main(String[] args) {
        //非法操作
        /*
        a=3;
        b="Lucy";
        map=new HashMap<>();
        */
        //FinalExample3 fe=new FinalExample3();
        //fe.test(2);
        //合法
        map.put(1,2);
        System.out.println(map.get(1));
    }
}
