package com.yha.functionalProgramming.defaultMethod;

/**
 * @author yha
 * @decription
 * @create 2017-10-07 23:36
 **/
public class OverridingChild extends OverridingParent implements IChild {

    public static void main(String[] args){
        IParent person = new OverridingChild();
        person.welcome();
    }
}
