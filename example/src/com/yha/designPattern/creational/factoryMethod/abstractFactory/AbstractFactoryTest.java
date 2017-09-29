package com.yha.designPattern.creational.factoryMethod.abstractFactory;

import com.yha.designPattern.creational.factoryMethod.Sender;

/**
 * @author yha
 * @decription
 * @create 2017-09-26 12:57
 **/
public class AbstractFactoryTest {

    public static void main(String[] args){

        Sender sms = new SmsSenderFactory().produce();
        sms.send();
        Sender mail = new MailSenderFactory().produce();
        mail.send();
        Sender letter = new LetterSenderFactory().produce();
        letter.send();
    }

}
