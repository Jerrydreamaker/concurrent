package com.iecas.concurrency.example.ImmuableObject;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class ImmutableExample1 {
    private final static ImmutableList<Integer> list=ImmutableList.of(1,2,3);
    private final static ImmutableSet<Integer> set=ImmutableSet.copyOf(list);

    public static void main(String[] args) {
        //不合法
        //set.add(1);
    }
}
