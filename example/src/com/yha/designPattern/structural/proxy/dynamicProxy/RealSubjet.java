package com.yha.designPattern.structural.proxy.dynamicProxy;

/**
 * @author yha
 * @Description 代理对象实现类
 * @date 2017/11/9
 */
public class RealSubjet implements Subject {

    @Override
    public void operation() {
        System.out.println("In RealSubject's operation();");
    }
}
