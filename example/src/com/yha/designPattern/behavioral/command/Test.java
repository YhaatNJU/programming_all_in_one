package com.yha.designPattern.behavioral.command;

/**
 * @author www
 * @Description: 测试类
 * @create 2017/9/29
 */
public class Test {

    public static void main(String[] args){

        Invoker commander = new Commander();
        commander.action();
    }
}
