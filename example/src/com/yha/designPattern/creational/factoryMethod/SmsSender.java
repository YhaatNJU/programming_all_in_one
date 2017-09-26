package com.yha.designPattern.creational.factoryMethod;

/**
 * @author yha
 * @decription Sender的短信实现类
 * @create 2017-09-26 12:23
 **/
public class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("This message is sent by SmsSender.");
    }
}
