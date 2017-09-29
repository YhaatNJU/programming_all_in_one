package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 抽象命令，包括一些实现
 * @create 2017/9/29
 */
public abstract class AbstractCommand implements Command{


    @Override
    public void exe() {
        if (getReceiver() == null)
            return;
        getReceiver().action();
    }
}
