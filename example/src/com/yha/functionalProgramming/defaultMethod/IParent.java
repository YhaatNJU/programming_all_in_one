package com.yha.functionalProgramming.defaultMethod;

/**
 * @author yha
 * @decription 父接口
 * @create 2017-10-07 23:26
 **/
public interface IParent {


    default void welcome(){
        System.out.println("Parent: hi!");
    }

}
