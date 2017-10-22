package com.yha.UnderstandJVM.classLoad.passiveReference;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 9:39
 **/
public class SuperClass {
    static {
        System.out.println("Super Class init!");
    }
    public static int value = 123;
}
