package com.yha.designPattern.behavioral.chainOfResponsibility;

/**
 * @author yha
 * @Description: 角色基类
 * @create 2017/9/29
 */
public abstract class AbstractHandler {

    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }
}
