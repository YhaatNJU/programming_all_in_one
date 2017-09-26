package com.yha.designPattern.structural.proxy.simpleProxy;

/**
 * @author yha
 * @decription 被代理的类
 * @create 2017-09-26 16:26
 **/
public class Source implements SourceInterface {

    @Override
    public void method() {
        System.out.println("The original method.");
    }
}
