package com.yha.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yha
 * @decription 读写锁测试
 * @create 2017-10-01 15:23
 **/
public class ReadWriteLockDemo {

    private static Lock lock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public int handleRead(Lock lock) throws InterruptedException{
        try {
            lock.lock(); //模拟读操作
            Thread.sleep(1000); //读操作的耗时越多，读写锁的优势就越明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int val) throws InterruptedException{
        try {
            lock.lock(); //模拟写操作
            Thread.sleep(1000);
            value = val;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    //demo.handleRead(readLock);
                    //使用重入锁会非常低效
                    demo.handleRead(lock);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    //demo.handleWrite(writeLock, 12);
                    //使用重入锁
                    demo.handleWrite(lock, 12);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 18; i++){
            new Thread(readRunnable).start();
        }
        for (int i = 18; i < 20; i++){
            new Thread(writeRunnable).start();
        }
    }
}
