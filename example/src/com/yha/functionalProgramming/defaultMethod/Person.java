package com.yha.functionalProgramming.defaultMethod;

/**
 * @author yha
 * @decription
 * @create 2017-10-07 23:32
 **/
public class Person implements IChild {


    public static void main(String[] args){
        IParent p = new Person();
        p.welcome();
    }
}
