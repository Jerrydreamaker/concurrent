package com.iecas.concurrency.example.ImmuableObject;

/**
 * 测试 final 关键字修饰的基本类型、引用类型的可变性。
 */
public class FinalExample1 {
    private final int a=1;
    private final String b="wlj";
    private final FinalUser fu=new FinalUser(18,"Lily");
    /*
    //非法
    public void setA(int a){
        this.a=a;
    }*/
    /*
    //非法
    public void setB(String b){
        this.b=b;
    }*/
    /*
    //非法
    public void setFu(FinalUser fu){
        this.fu=fu;
    }*/

    public FinalUser getFu() {
        return fu;
    }

    public void setFuAge(int age){
        this.fu.setAge(age);
    }

    public static void main(String[] args) {
        FinalExample1 fe=new FinalExample1();
        fe.setFuAge(10);
        System.out.println(fe.getFu().getAge());
    }
}
