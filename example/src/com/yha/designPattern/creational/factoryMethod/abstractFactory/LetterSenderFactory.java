package com.yha.designPattern.creational.factoryMethod.abstractFactory;

import com.yha.designPattern.creational.factoryMethod.Sender;

/**
 * @author yha
 * @decription 生产LetterSender的SenderFactory的实现类
 * @create 2017-09-26 12:56
 **/
public class LetterSenderFactory implements SenderFactory {

    @Override
    public Sender produce() {
        return new LetterSender();
    }
}
