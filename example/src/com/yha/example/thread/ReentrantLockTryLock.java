package com.yha.example.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yha
 * @decription 通过重入锁申请限时等待的锁
 * @create 2017-10-01 14:11
 **/
public class ReentrantLockTryLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getId() + " get lock succeed.");
                Thread.sleep(6000);
            }else {
                System.out.println(Thread.currentThread().getId() + " get lock failed.");
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
    public static void main(String[] args){
        ReentrantLockTryLock tryLock = new ReentrantLockTryLock();
        Thread t1 = new Thread(tryLock);
        Thread t2 = new Thread(tryLock);
        t1.start();
        t2.start();
    }
}
