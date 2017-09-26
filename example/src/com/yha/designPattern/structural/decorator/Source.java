package com.yha.designPattern.structural.decorator;

/**
 * @author yha
 * @decription 被装饰的类
 * @create 2017-09-26 16:04
 **/
public class Source implements SourceInterface {

    @Override
    public void method() {
        System.out.println("This is from Source's method.");
    }
}
