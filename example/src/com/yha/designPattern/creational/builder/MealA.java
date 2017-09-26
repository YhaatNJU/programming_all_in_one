package com.yha.designPattern.creational.builder;

/**
 * @author yha
 * @decription ConcreteBuilder Builder实现类，构造套餐A
 * @create 2017-09-26 13:56
 **/
public class MealA extends MealBuilder{


    @Override
    public void buildFood() {
        meal.setFood("一个霸王堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }
}
