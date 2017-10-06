package com.yha.example.multiThreads.myFutureDemo;

/**
 * @author yha
 * @decription 最终需要使用的数据类型，构造很慢
 * @create 2017-10-05 10:51
 **/
public class RealData implements Data {
    protected final String result;

    public RealData(String para){
        //RealData构造很慢，用户需要等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++)
            sb.append(para);
        try {
            //使用sleep模拟一个慢操作
            Thread.sleep(500);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        result = sb.toString();
    }

    @Override
    public String getData() {
        return result;
    }
}
