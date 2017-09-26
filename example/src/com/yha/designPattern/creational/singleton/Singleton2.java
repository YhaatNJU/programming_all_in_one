package com.yha.designPattern.creational.singleton;

/**
 * @author yha
 * @decription 线程安全的单例模式
 * @create 2017-09-26 13:06
 **/
public class Singleton2 {

    public static Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }

}
