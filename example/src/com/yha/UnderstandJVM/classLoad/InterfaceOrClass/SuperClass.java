package com.yha.UnderstandJVM.classLoad.InterfaceOrClass;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 12:48
 **/
public class SuperClass {
    static {
        //定义在静态块之后的静态变量，之前的静态块只能赋值，不能访问
        //下面语句报错
        //System.out.println(temp);
        //下面语句正常
        temp = 2;
    }
    public static int temp = 0;
    public static final int value = 12;
    public String instanceString = "super instance";
    public static String staticString = "super static";
    public void sayHello(){
        System.out.println("say hello from super class.");
    }
    public void sayGoodbye(){
        System.out.println("say goodbye from super class");
    }
    public static void sayHelloStatic(){
        System.out.println("from Super Class static");
    }
}
