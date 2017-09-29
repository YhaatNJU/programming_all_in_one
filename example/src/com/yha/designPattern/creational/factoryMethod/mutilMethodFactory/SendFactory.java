package com.yha.designPattern.creational.factoryMethod.mutilMethodFactory;

import com.yha.designPattern.creational.factoryMethod.MailSender;
import com.yha.designPattern.creational.factoryMethod.Sender;
import com.yha.designPattern.creational.factoryMethod.SmsSender;

/**
 * @author yha
 * @decription 多个工厂方法的工厂类
 * @create 2017-09-26 12:37
 **/
public class SendFactory {

    public Sender produceSms(){
        return new SmsSender();
    }

    public Sender produceMail(){
        return new MailSender();
    }

    public static void main(String[] args){
        SendFactory factory = new SendFactory();

        Sender smsSender = factory.produceSms();
        smsSender.send();
        Sender mailSender = factory.produceMail();
        mailSender.send();
    }

}
