package com.yha.designPattern.structural.bridge;

/**
 * @author yha
 * @decription
 * @create 2017-09-26 16:41
 **/
public class SourceSubA implements SourceInterface {

    @Override
    public void method() {
        System.out.println("SourceSubA's method.");
    }
}
