package com.yha.example.multiThreads.myFutureDemo;

/**
 * @author yha
 * @decription 实现一个快速返回的RealData的包装。它实际上是RealData的代理，封装了获取RealData的等待过程
 * @create 2017-10-05 10:55
 **/
public class FutureData implements Data {
    protected RealData realData = null; //包装的RealData
    protected boolean isReady = false;
    public synchronized void setResult(RealData result){

        if (isReady)
            return;

        this.realData = result;
        isReady = true;
        notifyAll(); // RealData已被注入，通知getResult()
    }
    public synchronized String getData(){
        //会等待RealData构造完成
        while (!isReady){
            try {
                wait(); //一直等待，直到结果被注入
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        return realData.result;
    }

}
