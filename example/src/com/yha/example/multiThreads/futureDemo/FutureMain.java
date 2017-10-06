package com.yha.example.multiThreads.futureDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author yha
 * @decription 相当于客户端类
 * @create 2017-10-05 11:22
 **/
public class FutureMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        //构造FutureTask
        FutureTask<String> future = new FutureTask<String>(new RealData("abcd"));
        ExecutorService service = Executors.newFixedThreadPool(1);
        //执行FutureTask，发送请求
        //在这里开启线程进行RealData的call()执行
        service.submit(future);
        System.out.println("请求完毕。");
        try {
            //这里用sleep模拟进行额外的任务
            Thread.sleep(1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        //获取真实结果
        System.out.println("resultData = " + future.get());
        service.shutdown();
    }

}
