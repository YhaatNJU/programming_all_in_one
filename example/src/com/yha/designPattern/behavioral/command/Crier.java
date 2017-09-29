package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 传令员（命令的中间接收者，接收发送电报的请求）
 * @create 2017/9/29
 */
public class Crier extends AbstractInvoker implements Receiver{

    @Override
    public Command getCommand() {
        return new SendMessage();
    }

    @Override
    public void action() {
        System.out.println("传令员：接到传递发送电报的命令，将命令交个发报员执行");
        Command command = new SendMessage();
        command.exe();
    }
}
