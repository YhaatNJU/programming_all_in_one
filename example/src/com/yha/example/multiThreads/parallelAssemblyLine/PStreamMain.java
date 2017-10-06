package com.yha.example.multiThreads.parallelAssemblyLine;

import java.util.Random;

/**
 * @author yha
 * @decription
 * @create 2017-10-05 15:42
 **/
public class PStreamMain {

    public static void main(String[] args) throws InterruptedException{

        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Divide()).start();

        Random random = new Random();
        int a,b,c,d;
        for (int i = 0; i < 10000000; i++){
            a = random.nextInt(100000) + 1;
            b = random.nextInt(100000) + 1;
            c = random.nextInt(100000) + 1;
            d = random.nextInt(100000) + 1;
            Msg msg = new Msg();
            msg.a = a;
            msg.b = b;
            msg.c = c;
            msg.d = d;
            msg.orgStr = String.format("( %d + %d ) * %d / %d", a, b, c, d);
            Plus.bq.add(msg);
        }
    }

}
