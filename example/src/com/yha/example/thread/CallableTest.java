package com.yha.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author yha
 * @decription 使用Callable接口的实现类和FutureTask来创建和管理新线程
 * @create 2017-09-18 14:57
 **/
public class CallableTest implements Callable<String>{

    public static void main(String[] args) throws Exception{

        CallableTest test = new CallableTest();
        FutureTask<String> task = new FutureTask<>(test);
        new Thread(task, "creational thread with Callable and FutureTask.").start();

        System.out.println(task.get());

    }


    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
