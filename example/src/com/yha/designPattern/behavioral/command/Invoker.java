package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 命令调用者接口
 * @create 2017/9/29
 */
public interface Invoker {

    Command getCommand();

    void action();
}
