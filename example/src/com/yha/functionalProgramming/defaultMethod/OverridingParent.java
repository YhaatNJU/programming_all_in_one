package com.yha.functionalProgramming.defaultMethod;

/**
 * @author yha
 * @decription
 * @create 2017-10-07 23:34
 **/
public class OverridingParent extends Person {

    public void welcome(){
        System.out.println("Overriding Parent: hi!");
    }

    public static void main(String[] args){
        IParent person = new OverridingParent();
        person.welcome();
    }

}
