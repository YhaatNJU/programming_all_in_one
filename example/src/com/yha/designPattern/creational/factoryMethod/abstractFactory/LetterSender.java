package com.yha.designPattern.creational.factoryMethod.abstractFactory;

import com.yha.designPattern.creational.factoryMethod.Sender;

/**
 * @author yha
 * @decription 采用书信方式的Sender实现类
 * @create 2017-09-26 12:54
 **/
public class LetterSender implements Sender {

    @Override
    public void send() {
        System.out.println("This message is sent by LetterSender.");
    }
}
