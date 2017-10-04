package com.yha.example.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author yha
 * @decription 让普通变量享有原子操作的AtomicIntegerFieldUpdater示例
 * @create 2017-10-04 8:56
 **/
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidate{
        int id;
        volatile int score;//被操作的变量必须是volatile的，且不能是static的，也不能是private的
    }
    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater =
            AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //对比检查Updater是否正常工作
    public static AtomicInteger allSore = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException{
        final Candidate candidate = new Candidate();
        Thread[] ts = new Thread[100000];
        for (int i = 0; i < 100000; i++){
            ts[i] = new Thread(){
                @Override
                public void run() {
                    if (Math.random() > 0.4){
                        scoreUpdater.incrementAndGet(candidate);
                        allSore.incrementAndGet();
                    }
                }
            };
            ts[i].start();
        }
        for (int i = 0; i < 100000; i++)
            ts[i].join();
        System.out.println("score = " + candidate.score);
        System.out.println("allScore = " + allSore);
    }

}
