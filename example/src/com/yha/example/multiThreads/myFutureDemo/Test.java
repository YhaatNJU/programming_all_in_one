package com.yha.example.multiThreads.myFutureDemo;

/**
 * @author yha
 * @decription
 * @create 2017-10-05 11:08
 **/
public class Test {

    public static void main(String[] args){

        Client client = new Client();
        //这里会被立即返回，因为得到的是FutureData而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕。");
        try {
            //这里用sleep模拟进行其他任务，表示充分利用等待时间
            Thread.sleep(2000);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        //使用真实数据
        System.out.println("realData = " + data.getData());

    }

}
