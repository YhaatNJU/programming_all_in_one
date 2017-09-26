package com.yha.designPattern.structural.adaptor.objectAdaptor;

import com.yha.designPattern.structural.adaptor.Source;
import com.yha.designPattern.structural.adaptor.TargetInterface;

/**
 * @author yha
 * @decription 对象适配器类
 * @create 2017-09-26 15:42
 **/
public class Wrapper implements TargetInterface {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("This is from the implement fo TargetInterface's method2.");
    }

    public static void main(String[] args){

        Source s = new Source();
        Wrapper wrapper = new Wrapper(s);
        wrapper.method1();
        wrapper.method2();
    }
}
