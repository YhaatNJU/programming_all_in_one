package com.yha.algorithm.sort.multiSort;

import java.util.Comparator;

/**
 * @author yha
 * @decription 包含多种比较方式的实体
 * @create 2017-09-21 22:00
 **/
public class Person {

    private String name;

    private int age;

    private int money;

    public String getName() {
        return name;
    }

    public Person(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static class AgeOrder implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age < o2.age ? -1 : o1.age == o2.age ? 0 : 1;
        }

    }

    public static class MoneyOrder implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            return o1.money < o2.money ? -1 : o1.money == o2.money ? 0 : 1;
        }
    }

}
