package com.yha.designPattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @author yha
 * @decription 监听者管理接口实现类
 * @create 2017-09-26 18:16
 **/
public class MySubject implements ISubject {

    private List<IObserver> observers;

    public MySubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void add(IObserver observer) {
        if (observer != null)
            observers.add(observer);
    }

    @Override
    public void del(IObserver observer) {
        if (observer != null)
            observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver o : observers)
            o.update();
    }

    @Override
    public void operation() {
        System.out.println("MySubject's operation.");
    }

    public static void main(String[] args){

        ISubject subject = new MySubject();
        IObserver observer = new ObserverA();
        subject.add(observer);
        observer = new ObserverB();
        subject.add(observer);

        subject.operation();

        subject.notifyObservers();

    }
}
