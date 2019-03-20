package com.iecas.concurrency.example;

public class ByteCulExample {
    public static void main(String[] args) {

        // 2^n-1 形式为 000111，其中 1 的 个数为 n
        // 所以高位归 0，低位保持不变，相当于取模。
        //3=011
        //5=101
        //System.out.println(3&5);
        //System.out.println(tableSizeFor(6));
        // 18=00010010
        // 4=00000100
        //System.out.println(right2(18));
        // -18=10010010
        // -5=10000101
        System.out.println(right2(-18));
        //System.out.println(spread(-2));

    }

    static final int tableSizeFor(int cap) {

        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }

    static final int spread(int h) {
        return h>>>16;
        //return (h ^ (h >>> 16)) & 0x7fffffff;
    }

    static final int right2(int h){
        return h>>2;
    }
}
