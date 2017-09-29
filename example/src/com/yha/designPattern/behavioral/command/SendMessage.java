package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 实际执行发送电报指令的命令
 * @create 2017/9/29
 */
public class SendMessage extends AbstractCommand {

    @Override
    public Receiver getReceiver() {
        Receiver receiver = new Telegrapher();
        return receiver;
    }
}
