package com.yha.designPattern.behavioral.observer;

/**
 * @author yha
 * @decription 观察者A
 * @create 2017-09-26 18:10
 **/
public class ObserverA implements IObserver {

    @Override
    public void update() {
        System.out.println("ObserverA has received.");
    }
}
