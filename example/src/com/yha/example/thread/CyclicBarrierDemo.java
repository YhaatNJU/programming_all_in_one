package com.yha.example.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yha
 * @decription 循环栅栏测试
 * @create 2017-10-01 17:17
 **/
public class CyclicBarrierDemo{
    public static class Soldier implements Runnable{
        private String name;
        private final CyclicBarrier cyclic;

        Soldier(CyclicBarrier cyclic, String soldierName){
            this.name = soldierName;
            this.cyclic = cyclic;
        }
        @Override
        public void run() {
            try {
                //等到所有的士兵都到齐
                cyclic.await();
                doWork();
                //等待所有士兵完成任务
                cyclic.await();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }catch (BrokenBarrierException bbe){
                bbe.printStackTrace();
            }
        }
        void doWork(){
            try {
                Thread.sleep(new Random().nextInt(5));
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println(name + " 任务完成。");
        }
    }
    public static class BarrierRun implements Runnable{
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }
        @Override
        public void run() {
            if (flag){
                System.out.println("司令：[士兵" + N + "个，完成任务！]");
            }else {
                System.out.println("司令：[士兵" + N + "个，集结完毕！]");
                flag = true;
            }
        }
    }
    public static void main(String[] args){
        final  int N = 5;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(false, N));
        //设置障碍点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < N; i++){
            System.out.println("士兵" + i  + "报道！");
            allSoldier[i] = new Thread(new Soldier(cyclic, "士兵" + i));
            allSoldier[i].start();
        }

    }
}
