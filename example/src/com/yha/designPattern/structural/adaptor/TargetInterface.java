package com.yha.designPattern.structural.adaptor;

/**
 * 目标接口，希望把Source类的方法拓展到此接口的实现类中
 */
public interface TargetInterface {

    /**
     * 与Source类中的方法相同，Source方法的实现会替代此方法
     */
    void method1();

    /**
     * 新类的方法
     */
    void method2();
}
