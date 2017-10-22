package com.yha.UnderstandJVM.classLoad.InterfaceOrClass;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 12:49
 **/
public interface IInterface {
    int value = 5;
    default void sayHello(){
        System.out.println("say hello from interface.");
    }
}
