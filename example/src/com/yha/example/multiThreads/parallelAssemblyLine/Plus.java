package com.yha.example.multiThreads.parallelAssemblyLine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yha
 * @decription 进行加法操作的线程类
 * @create 2017-10-05 15:22
 **/
public class Plus implements Runnable {

    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                msg.b = msg.a + msg.b;
                Multiply.bq.add(msg);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
