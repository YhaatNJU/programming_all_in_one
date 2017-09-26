package com.yha.designPattern.structural.bridge;

/**
 * @author yha
 * @decription
 * @create 2017-09-26 16:42
 **/
public class SourceSubB implements SourceInterface {

    @Override
    public void method() {
        System.out.println("SourceSubB's method.");
    }
}
