package com.yha.example.multiThreads.parallelAssemblyLine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yha
 * @decription 进行乘法操作的线程类
 * @create 2017-10-05 15:25
 **/
public class Multiply implements Runnable{
    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true){
            try {
                Msg  msg = bq.take();
                msg.c = msg.b * msg.c;
                Divide.bq.add(msg);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
