package com.yha.example.thread;

/**
 * @author yha
 * @decription 使用Runnable接口的实现类来创建新的线程
 * @create 2017-09-18 14:49
 **/
public class RunnableTest implements Runnable{


    @Override
    public void run() {
        System.out.println("create new thread by implementing Runnable");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){

        RunnableTest test = new RunnableTest();
        new Thread(test, "新线程1").start();
        new Thread(test, "新线程2").start();

    }

}
