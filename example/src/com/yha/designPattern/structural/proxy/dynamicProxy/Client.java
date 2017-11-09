package com.yha.designPattern.structural.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yha
 * @Description 上下文类
 * @date 2017/11/9
 */
public class Client {

    public static void main(String[] args){
        //指定被代理的对象
        Subject s = new RealSubjet();

        InvocationHandler handler = new MyHandler(s);

        Class cl = s.getClass();

        //生成代理
        Subject subject = (Subject) Proxy.newProxyInstance(cl.getClassLoader(), cl.getInterfaces(), handler);
        subject.operation();
    }
}
