package com.yha.UnderstandJVM.classLoad.InterfaceOrClass;

/**
 * @author yha
 * @decription
 * @create 2017-10-11 12:49
 **/
public class SubClass extends SuperClass implements IInterface {
    public static void sayHelloStatic(){
        System.out.println("from Sub Class static");
    }
    public void sayGoodbye(){
        System.out.println("say goodbye from sub class");
    }
    public String instanceString = "sub instance";
    public static String staticString = "sub static";
    public static void main(String[] args){
        //类的继承优先级大于接口
        //只有实例方法会动态绑定
        //类变量和类方法会从声明的类型按照继承体系从下往上查找
        SubClass subClass = new SubClass();
        subClass.sayHello();
        subClass.sayGoodbye();
        subClass.sayHelloStatic();
        System.out.println(subClass.staticString);
        System.out.println(subClass.instanceString);
        //如果声明的类型是SubClass,下面的语句会报错
        //System.out.println(subClass.value);
    }
}
