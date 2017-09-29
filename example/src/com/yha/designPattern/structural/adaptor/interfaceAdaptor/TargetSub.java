package com.yha.designPattern.structural.adaptor.interfaceAdaptor;

import com.yha.designPattern.structural.adaptor.TargetInterface;

/**
 * @author yha
 * @decription 目标接口的空实现类（所有方法都是空实现，然后其他需要目标接口时只需继承此类并覆盖需要的方法）
 * @create 2017-09-26 15:56
 **/
public class TargetSub implements TargetInterface{

    @Override
    public void method1() {
        //空实现
    }

    @Override
    public void method2() {
        //空实现
    }
}
