package com.yha.designPattern.creational.singleton;

/**
 * @author yha
 * @Description 使用静态内部类的单例模式
 * @date 2017/11/9
 */
public class Singleton3 {

    public static Singleton3 getInstance(){
        return SingleTonHolder.singleton;
    }

    private static class SingleTonHolder{
        private static Singleton3 singleton = new Singleton3();

    }
}
