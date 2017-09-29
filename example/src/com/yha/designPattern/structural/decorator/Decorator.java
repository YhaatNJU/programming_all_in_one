package com.yha.designPattern.structural.decorator;

/**
 * @author yha
 * @decription 装饰器类
 * @create 2017-09-26 16:07
 **/
public class Decorator implements SourceInterface {

    private Source source;

    public Decorator(Source source) {
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
    }

    //新添加的方法
    public void method2(){
        System.out.println("Decorator's method2");
    }

    public static void main(String[] args){

        Source source = new Source();
        Decorator decorator = new Decorator(source);
        decorator.method();
        decorator.method2();
    }
}
