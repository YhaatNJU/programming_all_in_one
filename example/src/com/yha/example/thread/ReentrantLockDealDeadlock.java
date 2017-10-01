package com.yha.example.thread;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yha
 * @decription 使用ReentrantLock解决死锁问题
 * @create 2017-10-01 13:56
 **/
public class ReentrantLockDealDeadlock implements Runnable {

    private int lock;

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    public ReentrantLockDealDeadlock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1){
                //添加可以响应中断的锁
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                lock2.lockInterruptibly();
            }else {
                //添加可以响应中断的锁
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException{

        ReentrantLockDealDeadlock r1 = new ReentrantLockDealDeadlock(1);
        ReentrantLockDealDeadlock r2 = new ReentrantLockDealDeadlock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);

        t2.interrupt();
    }
}
