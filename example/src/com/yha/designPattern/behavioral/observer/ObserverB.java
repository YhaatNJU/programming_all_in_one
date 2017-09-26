package com.yha.designPattern.behavioral.observer;

/**
 * @author yha
 * @decription 观察者B
 * @create 2017-09-26 18:12
 **/
public class ObserverB implements IObserver {

    @Override
    public void update() {
        System.out.println("ObserverB has received.");
    }
}
