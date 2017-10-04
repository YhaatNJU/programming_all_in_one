package com.yha.example.thread;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author yha
 * @decription 无锁数组AtomicIntegerArray示例
 * @create 2017-10-04 8:29
 **/
public class AtomicIntegerArrayDemo {
    static AtomicIntegerArray integerArray = new AtomicIntegerArray(10);
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int k = 0; k < 100000; k++)
                integerArray.getAndIncrement(k % integerArray.length());
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int k = 0; k < 10; k ++)
            threads[k] = new Thread(new AddThread());
        for (int k = 0; k < 10; k ++)
            threads[k].start();
        for (int k = 0; k < 10; k ++)
            threads[k].join();
        System.out.println(integerArray);
    }

}
