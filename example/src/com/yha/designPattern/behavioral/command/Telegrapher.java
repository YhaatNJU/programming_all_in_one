package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 电报员（命令最终执行者)
 * @create 2017/9/29
 */
public class Telegrapher implements Receiver {

    @Override
    public void action() {
        System.out.println("发报员：成功发送电报.");
    }
}
