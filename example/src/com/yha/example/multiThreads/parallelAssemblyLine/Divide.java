package com.yha.example.multiThreads.parallelAssemblyLine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author yha
 * @decription 进行除法操作的线程类
 * @create 2017-10-05 15:26
 **/
public class Divide implements Runnable{

    public static BlockingQueue<Msg> bq = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true){
            try {
                Msg msg = bq.take();
                double re = msg.c / msg.d;
                System.out.println(msg.orgStr + String.format(" = %.3f", re));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
