package com.yha.algorithm.adt.bag;


/**
 * Author:yha
 * Description:背包基类，一种用来收集数据的adt
 * Time:2017/9/24 下午2:25.
 * Illustration:
 */
public abstract class Bag<Item> implements Iterable<Item> {

    public abstract void add(Item item);

    public abstract boolean isEmpty();

    public abstract int size();

    public void show() {

        for (Item item : this) {
            System.out.println(item);
        }
    }

    public abstract boolean contains(Item item);

}
