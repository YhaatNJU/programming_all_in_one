package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 命令接口
 * @create 2017/9/29
 */
public interface Command {

    /**
     * 命令执行
     */
    void exe();

    /**
     * 获取命令接收者
     */
    Receiver getReceiver();
}
