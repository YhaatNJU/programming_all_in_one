package com.yha.designPattern.structural.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yha
 * @Description 代理实现类
 * @date 2017/11/9
 */
public class MyHandler implements InvocationHandler {

    /**
     * 代理对象
     */
    private Object subject;

    public MyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke method: " + method);
        method.invoke(subject, args);
        System.out.println("After invoke method: " + method);
        return null;
    }
}
