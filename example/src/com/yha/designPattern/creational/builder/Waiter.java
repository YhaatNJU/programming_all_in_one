package com.yha.designPattern.creational.builder;

/**
 * @author yha
 * @decription Director 指挥者， 主要用来创建复杂对象。
 * 隔离了客户与对象的生产过程，负责控住产品对象的生产过程
 * @create 2017-09-26 15:13
 **/
public class Waiter {

    MealBuilder builder;

    public void setBuilder(MealBuilder builder) {
        this.builder = builder;
    }

    public Meal constract(){
        //准备食物
        builder.buildFood();

        //准备饮料
        builder.buildDrink();

        //准备完毕，将一个处理好的对象返回给客户

        return builder.getMeal();
    }

    public static void main(String[] args){

        MealBuilder builderA = new MealA();

        Waiter waiter = new Waiter();
        waiter.setBuilder(builderA);
        Meal mealA = waiter.constract();

        MealBuilder builderB = new MealB();
        waiter.setBuilder(builderB);
        Meal mealB = waiter.constract();

        System.out.println(mealA);
        System.out.println(mealB);
    }
}
