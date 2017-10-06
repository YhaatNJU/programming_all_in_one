package com.yha.example.multiThreads.simpleProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author yha
 * @decription 消费者，负责从内存缓冲区取数字求平方并输出
 * @create 2017-10-04 12:23
 **/
public class Consumer implements Runnable {
    private BlockingQueue<IntegerData> queue;
    private static final int SLEEP_TIME = 1000;
    private volatile boolean isRunning = false;

    public Consumer(BlockingQueue<IntegerData> queue) {
        this.queue = queue;
        isRunning = true;
    }

    @Override
    public void run() {
        System.out.println("start consumer id = " + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (isRunning){
                IntegerData data = queue.take();
                if (null != data){
                    int i = data.getIntData();
                    int re = i * i;
                    System.out.format("%d * %d = %d\n", i, i, re);
                    Thread.sleep(r.nextInt(SLEEP_TIME));
                }else {
                    System.err.println("Failed to take data.");
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
