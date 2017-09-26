package com.yha.designPattern.behavioral.observer;

/**
 * 监听者管理接口
 */
public interface ISubject {

    /**
     * 添加监听者
     * @param observer
     */
    void add(IObserver observer);

    /**
     * 删除监听者
     * @param observer
     */
    void del(IObserver observer);

    /**
     * 通知所有监听者
     */
    void notifyObservers();

    /**
     * 自身的其他操作
     */
    void operation();
}
