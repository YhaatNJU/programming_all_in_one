package com.yha.functionalProgramming.defaultMethod;

/**
 * @author yha
 * @decription 孩子接口
 * @create 2017-10-07 23:30
 **/
public interface IChild extends IParent {

    default void welcome(){
        System.out.println("Child: hi!");
    }
}
