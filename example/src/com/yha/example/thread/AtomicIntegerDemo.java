package com.yha.example.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yha
 * @decription 测试CAS操作实现的AtomicInteger类的线程安全性
 * @create 2017-10-03 23:23
 **/
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++)
                i.incrementAndGet();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++)
            threads[j] = new Thread(new AddThread());
        for (int j = 0; j < 10; j++)
            threads[j].start();
        for (int j = 0; j < 10; j++)
            threads[j].join();
        System.out.println(i);
    }

}
