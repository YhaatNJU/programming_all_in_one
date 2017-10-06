package com.yha.example.multiThreads.futureDemo;

import java.util.concurrent.Callable;

/**
 * @author yha
 * @decription 实现了Callable接口的数据类，主要负责真实数据的构造，可能很耗时间
 * @create 2017-10-05 11:18
 **/
public class RealData implements Callable<String> {
    private String para;

    public RealData(String para) {
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++){
            sb.append(para);
        }
        try {
            //使用sleep模拟耗时操作
            Thread.sleep(1000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return sb.toString();
    }
}
