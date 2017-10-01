package com.yha.example.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yha
 * @decription 信号量测试
 * @create 2017-10-01 15:03
 **/
public class SemaporeDemo implements Runnable {

    final Semaphore semp = new Semaphore(5);
    @Override
    public void run() {
        try {
            semp.acquire();
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " done!");
            semp.release();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(20);
        final SemaporeDemo demo = new SemaporeDemo();
        for (int i = 0; i < 20; i++){
            service.submit(demo);
        }
        service.shutdown();
    }
}
