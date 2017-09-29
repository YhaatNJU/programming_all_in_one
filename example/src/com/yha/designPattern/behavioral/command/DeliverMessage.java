package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 传递发送命令信息的命令
 * @create 2017/9/29
 */
public class DeliverMessage extends AbstractCommand {

    @Override
    public Receiver getReceiver() {
        Receiver receiver = new Crier();
        return receiver;
    }
}
