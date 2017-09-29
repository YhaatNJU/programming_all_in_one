package com.yha.designPattern.structural.adaptor.classAdaptor;

import com.yha.designPattern.structural.adaptor.Source;
import com.yha.designPattern.structural.adaptor.TargetInterface;

/**
 * @author yha
 * @decription 适配器类，负责将Source中的方法和TargetInterface中的方法整合起来
 * @create 2017-09-26 15:37
 **/
public class Adaptor extends Source implements TargetInterface {

    @Override
    public void method2() {
        System.out.println("This is from the implement fo TargetInterface's method2.");
    }

    public static void main(String[] args){

        Adaptor adaptor = new Adaptor();
        adaptor.method1();
        adaptor.method2();
    }
}
