package com.iecas.concurrency.example.status;

/**
 * 暂停当前正在执行的线程对象，并执行其他线程，静态方法。
 */
public class YieldDemo01 extends Thread{
    public static void main(String[] args) throws InterruptedException {
        //Thread t=new JoinDemo01();
        YieldDemo01 demo01=new YieldDemo01();
        Thread t=new Thread(demo01);
        t.start();
        for (int i=0;i<1000;i++){
            if(i%20==0){
                Thread.yield();//main 方法暂停,可能暂停后又被调用。
            }
            System.out.println("main..."+i);
        }
    }
    @Override
    public void run(){
        for (int i=0;i<1000;i++){
            System.out.println("yield..."+i);
        }
    }
}
