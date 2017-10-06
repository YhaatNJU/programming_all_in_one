package com.yha.example.multiThreads.myFutureDemo;

/**
 * @author yha
 * @decription 客户端程序。主要实现了获取FutureData，并开启构造RealData的线程。并在接受请求后，很快的返回FutureData。
 * @create 2017-10-05 11:03
 **/
public class Client {

    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            @Override
            public void run() {
                //RealData构造很慢，所以在单独的线程中构造
                RealData realData = new RealData(queryStr);
                future.setResult(realData);
            }
        }.start();

        return future; //FutureData会被立即返回
    }

}
