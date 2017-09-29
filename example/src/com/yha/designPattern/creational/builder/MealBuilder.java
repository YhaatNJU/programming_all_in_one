package com.yha.designPattern.creational.builder;

/**
 * @author yha
 * @decription Builder 构造器基类 一般包括很多操作产品属性的很多方法和获得产品的方法
 * @create 2017-09-26 13:53
 **/
public abstract class MealBuilder {

    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
