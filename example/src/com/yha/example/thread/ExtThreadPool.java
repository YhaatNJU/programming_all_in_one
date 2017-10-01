package com.yha.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author:yha
 * Description:扩展线程池
 * Time:2017/10/2 上午12:49.
 * Illustration:
 */
public class ExtThreadPool {
    public static class MyTask implements Runnable{
        public String name;
        public MyTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("正在执行->Thread ID:" + Thread.currentThread().getId() + ", Task Name:" + name);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        ExecutorService es = new ThreadPoolExecutor(5 , 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成：" + ((MyTask) r).name);
            }
            @Override
            protected void terminated() {
                System.out.println("线程池退出。");
            }
        };
        for(int i = 0; i < 5; i++){
            MyTask task = new MyTask("TASK-GYEYM-" + i);
            es.execute(task);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
