package com.yha.designPattern.creational.builder;

/**
 * @author yha
 * @decription ConcreteBuilder Builder的实现类，构建套餐B
 * @create 2017-09-26 15:09
 **/
public class MealB extends MealBuilder {

    @Override
    public void buildFood() {
        meal.setFood("一个墨西哥鸡肉卷");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯雪碧");
    }
}
