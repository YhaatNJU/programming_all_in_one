package com.yha.designPattern.creational.factoryMethod.staticFactory;

import com.yha.designPattern.creational.factoryMethod.MailSender;
import com.yha.designPattern.creational.factoryMethod.Sender;
import com.yha.designPattern.creational.factoryMethod.SmsSender;

/**
 * @author yha
 * @decription 静态工厂方法模式
 * @create 2017-09-26 12:44
 **/
public class SenderFactory {
    
    public static Sender produceSms(){
        return new SmsSender();
    }

    public static Sender produceMail(){
        return new MailSender();
    }

    public static void main(String[] args){

        Sender smsSender = SenderFactory.produceSms();
        smsSender.send();
        Sender mailSender = SenderFactory.produceMail();
        mailSender.send();
    }

}
