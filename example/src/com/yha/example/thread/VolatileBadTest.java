package com.yha.example.thread;

/**
 * @author yha
 * @decription volatile的不确定测试
 * @create 2017-10-01 10:01
 **/
public class VolatileBadTest implements Runnable {

    static VolatileBadTest instance = new VolatileBadTest();
    static volatile int i;

    public static void increase(){
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++)
            increase();
    }

    public static void main(String[] args) throws InterruptedException{

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i);
    }
}
