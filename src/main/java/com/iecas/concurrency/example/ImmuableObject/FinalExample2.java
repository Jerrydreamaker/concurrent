package com.iecas.concurrency.example.ImmuableObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 修饰 final 关键字修饰的容器类型的可变性。
 */
public class FinalExample2 {
    private final Map<Integer,Integer> map=new HashMap<>();
    /*
    //不合法
    public void setMap(){
        this.map=new HashMap();
    }*/
}
