package com.yha.designPattern.creational.singleton;

/**
 * @author yha
 * @decription 简单但非线程安全的单例模式
 * @create 2017-09-26 13:01
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

}
