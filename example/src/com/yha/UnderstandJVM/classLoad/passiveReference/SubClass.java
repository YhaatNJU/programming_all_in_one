package com.yha.UnderstandJVM.classLoad.passiveReference;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 9:41
 **/
public class SubClass extends SuperClass {
    static {
        System.out.println("Sub Class init!");
    }
}
