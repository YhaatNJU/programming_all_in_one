package com.yha.designPattern.creational.builder;

/**
 * @author yha
 * @decription Product 被创建的产品，一般是一个比较复杂的对象
 * @create 2017-09-26 13:52
 **/
public class Meal {

    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "food='" + food + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
