package com.iecas.concurrency.example.ImmuableObject;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

public class UnmodifiableExample1 {
    private static Map<Integer,Integer> map= Maps.newHashMap();
    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map= Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        //不合法
        //map.put(7,8);
    }
}
