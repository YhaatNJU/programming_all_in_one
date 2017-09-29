package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 司令
 * @create 2017/9/29
 */
public class Commander extends AbstractInvoker {

    @Override
    public Command getCommand() {
        Command command = new DeliverMessage();
        return command;
    }
}
