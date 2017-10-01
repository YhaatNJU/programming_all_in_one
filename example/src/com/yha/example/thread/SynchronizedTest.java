package com.yha.example.thread;

/**
 * @author yha
 * @decription synchronize的三种用法
 * @create 2017-10-01 10:19
 **/
public class SynchronizedTest {

    SynchronizedTest object =new SynchronizedTest();

    private int i;
    private static int j;

    /**
     * 实例方法上使用synchronized，相当于对当前实例加锁
     */
    public synchronized void instanceMethod(){
        i++;
    }

    /**
     * 类方法上使用synchronized，相当于对当前类加锁
     */
    public synchronized static void staticMethod(){
        j++;
    }

    /**
     * 在对象上使用synchronized
     */
    void doSomething(){
        synchronized (object){
            i++;
        }
    }
}
