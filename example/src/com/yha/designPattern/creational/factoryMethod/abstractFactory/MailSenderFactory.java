package com.yha.designPattern.creational.factoryMethod.abstractFactory;

import com.yha.designPattern.creational.factoryMethod.MailSender;
import com.yha.designPattern.creational.factoryMethod.Sender;

/**
 * @author yha
 * @decription 生产MailSender的SenderFactory的实现类
 * @create 2017-09-26 12:53
 **/
public class MailSenderFactory implements SenderFactory {

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
