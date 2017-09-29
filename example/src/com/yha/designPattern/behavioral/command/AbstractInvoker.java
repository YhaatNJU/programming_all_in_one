package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 抽象命令调用者，实现了一些接口
 * @create 2017/9/29
 */
public abstract class AbstractInvoker implements Invoker {


    @Override
    public void action() {
        if (getCommand() == null)
            return;
        getCommand().exe();
    }
}
