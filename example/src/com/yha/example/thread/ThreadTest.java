package com.yha.example.thread;

/**
 * @author yha
 * @decription 使用Thread的实现类创建新线程
 * @create 2017-09-18 14:46
 **/
public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("crate thread with subClass of Thread.");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){

        Thread thread = new ThreadTest();
        thread.start();
    }
}
