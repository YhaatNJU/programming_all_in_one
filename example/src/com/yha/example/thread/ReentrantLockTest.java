package com.yha.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yha
 * @decription 重入锁测试
 * @create 2017-10-01 13:37
 **/
public class ReentrantLockTest implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++){
            lock.lock();
            //可以多次加锁（仅针对同一个线程）
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
                //也需要释放同样次数，否则会产生死锁,但是释放多了会抛出IllegalMonitorException
                lock.unlock();
                //lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{

        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
