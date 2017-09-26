package com.yha.designPattern.creational.factoryMethod.commonFactory;

import com.yha.designPattern.creational.factoryMethod.MailSender;
import com.yha.designPattern.creational.factoryMethod.Sender;
import com.yha.designPattern.creational.factoryMethod.SmsSender;

/**
 * @author yha
 * @decription 普通工程方法类
 * @create 2017-09-26 12:26
 **/
public class SendFactory {


    public static final String SMS_SENDER = "sms";
    public static final String MAIL_SENDER = "mail";

    public Sender produce(String type){
        if (SMS_SENDER.equals(type))
            return new SmsSender();
        else if (MAIL_SENDER.equals(type))
            return new MailSender();
        else{
            throw new Error("Wrong type of sender: " + type);
        }
    }

    public static void main(String[] args){

        SendFactory factory = new SendFactory();

        Sender sms = factory.produce(SendFactory.SMS_SENDER);
        sms.send();

        Sender mail = factory.produce(SendFactory.MAIL_SENDER);
        mail.send();

        //Sender other = factory.produce("abc");
    }

}
