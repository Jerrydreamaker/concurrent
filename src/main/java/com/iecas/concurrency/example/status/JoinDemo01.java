package com.iecas.concurrency.example.status;
/**
 * 合并线程，等待该线程的终止，成员方法。
 */
public class JoinDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {
        //Thread t=new JoinDemo01();
        JoinDemo01 demo01=new JoinDemo01();
        Thread t=new Thread(demo01);
        t.start();
        for (int i=0;i<1000;i++){
            if(i==700){
                t.join();//main 方法阻塞
            }
            System.out.println("main..."+i);
        }
    }
    @Override
    public void run(){
        for (int i=0;i<1000;i++){
            System.out.println("join..."+i);
        }
    }
}
