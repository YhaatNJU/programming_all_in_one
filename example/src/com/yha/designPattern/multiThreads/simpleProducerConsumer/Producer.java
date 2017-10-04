package com.yha.designPattern.multiThreads.simpleProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yha
 * @decription 生产者，辅助向共享区添加用来求平方的数字
 * @create 2017-10-04 12:08
 **/
public class Producer implements Runnable {
    private volatile boolean isRunning = false;
    private BlockingQueue<IntegerData> queue; //内存缓存区
    private static AtomicInteger count = new AtomicInteger(); //生产者总数，原子操作
    private static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<IntegerData> queue) {
        this.queue = queue;
        isRunning = true;
    }

    @Override
    public void run() {
        IntegerData data = null;
        Random r = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEP_TIME));
                data = new IntegerData(count.incrementAndGet()); // 构造任务数据
                System.out.println(data + " is put into queue.");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)){ //提交数据到内存缓存区
                    System.err.println("Failed to put data: " + data);
                }
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
