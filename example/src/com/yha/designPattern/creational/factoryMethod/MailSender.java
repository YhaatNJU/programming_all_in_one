package com.yha.designPattern.creational.factoryMethod;

/**
 * @author yha
 * @decription Sener的邮件实现类
 * @create 2017-09-26 12:25
 **/
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("This message is sent by MailSender.");
    }
}
