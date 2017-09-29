package com.yha.designPattern.behavioral.chainOfResponsibility;

/**
 * @author www
 * @Description: 角色子类
 * @create 2017/9/29
 */
public class MyHandler extends AbstractHandler implements Handler {

    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {

        System.out.println(name + " deal!");

        if (getHandler() != null){
            getHandler().operator();
        }
    }

    public static void main(String[] args){

        MyHandler handler1 = new MyHandler("handler1");

        MyHandler handler2 = new MyHandler("handler2");

        MyHandler handler3 = new MyHandler("handler3");

        handler1.setHandler(handler2);

        handler2.setHandler(handler3);

        handler1.operator();
    }
}
