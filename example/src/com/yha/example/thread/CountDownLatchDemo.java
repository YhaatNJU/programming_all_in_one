package com.yha.example.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yha
 * @decription 倒计时器测试
 * @create 2017-10-01 15:59
 **/
public class CountDownLatchDemo implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println(Thread.currentThread().getId() + " check complete.");
            //减少计数器
            end.countDown();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++){
            service.submit(demo);
        }
        //主线程等待检查
        end.await();
        System.out.println("Fire!");
        service.shutdown();
    }
}
