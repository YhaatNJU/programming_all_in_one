package com.yha.designPattern.structural.bridge;

/**
 * @author yha
 * @decription 连接器实现类
 * @create 2017-09-26 16:45
 **/
public class MyBridge extends Bridge {

    @Override
    public void method() {
        getSource().method();
    }

    public static void main(String[] args){

        Bridge bridge = new MyBridge();

        //调用A实现类
        SourceInterface source = new SourceSubA();
        bridge.setSource(source);
        bridge.method();

        //调用B实现类
        source = new SourceSubB();
        bridge.setSource(source);
        bridge.method();
    }

}
