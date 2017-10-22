package com.yha.UnderstandJVM.classLoad.passiveReference;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 9:45
 **/
public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "Hello World!";

}
