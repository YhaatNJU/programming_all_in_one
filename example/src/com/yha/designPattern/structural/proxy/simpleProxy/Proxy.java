package com.yha.designPattern.structural.proxy.simpleProxy;

/**
 * @author yha
 * @decription 代理类
 * @create 2017-09-26 16:26
 **/
public class Proxy implements SourceInterface {

    private Source source;

    public Proxy() {

        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before(){
        System.out.println("Before proxy.");
    }

    private void after(){
        System.out.println("After proxy");
    }

    public static void main(String[] args){

        SourceInterface source = new Proxy();
        source.method();
    }
}
