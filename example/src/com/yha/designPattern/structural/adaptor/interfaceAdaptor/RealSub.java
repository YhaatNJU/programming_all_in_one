package com.yha.designPattern.structural.adaptor.interfaceAdaptor;

/**
 * @author yha
 * @decription 真正需要的实现类，继承自间接实现类，然后覆盖自己需要的方法
 * @create 2017-09-26 15:58
 **/
public class RealSub extends TargetSub {

    //只需方法method1,覆盖它即可
    @Override
    public void method1() {
        System.out.println("This is from RealSub's method1");
    }

    public static void main(String[] args){

        RealSub sub = new RealSub();

        sub.method1();

        //空的实现，不会做任何操作
        sub.method2();
    }
}
