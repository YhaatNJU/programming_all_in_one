package com.yha.algorithm.sort.multiSort;

/**
 * @author yha
 * @decription 多键值比较测试类
 * @create 2017-09-21 22:06
 **/
public class MultiSortTest {

    public static void main(String[] args){

        Person p1 = new Person("Tom", 25, 1000000);
        Person p2 = new Person("Jack", 22, 12000000);
        Person p3 = new Person("Lucy", 30, 233333);


        Person[] a = {p1, p2, p3};

        System.out.println("Order by age:");
        MultiSort.sort(a, new Person.AgeOrder());

        for (Person p : a)
            System.out.println(p.getName());

        System.out.println("Order by money");
        MultiSort.sort(a, new Person.MoneyOrder());
        for (Person p : a)
            System.out.println(p.getName());

    }

}
