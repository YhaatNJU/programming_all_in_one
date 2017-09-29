package com.yha.designPattern.creational.factoryMethod.abstractFactory;

import com.yha.designPattern.creational.factoryMethod.Sender;
import com.yha.designPattern.creational.factoryMethod.SmsSender;

/**
 * @author yha
 * @decription 可以生产SmsSender的SenderFactory实现类
 * @create 2017-09-26 12:51
 **/
public class SmsSenderFactory implements SenderFactory {

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
