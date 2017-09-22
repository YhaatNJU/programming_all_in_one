package com.yha.algorithm.adt.symbolTable;

import java.util.Iterator;

/**
 * @author yha
 * @decription 符号表基类
 * @create 2017-09-22 16:12
 **/
public abstract class SymbolTable<Key, Value> {

    public SymbolTable(){

    }

    /**
     * 将键值对存入表中（若值为空则将键key从表中删除）
     * @param key
     * @param val
     */
    public abstract void put(Key key, Value val);

    /**
     * 获取键key对应的值（若键key不存在则返回null）
     * @param key
     * @return
     */
    public abstract Value get(Key key);

    /**
     * 从表中删除键key（及其对应的值）
     * @param key
     */
    public abstract void delete(Key key);

    /**
     * 键key在表中是否有对应的值
     * @param key
     * @return
     */
    public abstract boolean contains(Key key);

    /**
     * 表是否为空
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * 表中的键值对实例
     * @return
     */
    public abstract int size();

    /**
     * 表中所有键的集合
     * @return
     */
    public abstract Iterable<Key> keys();

    public void show(){
        Iterator<Key> iterator = keys().iterator();
        while (iterator.hasNext()){
            Key next = iterator.next();
            System.out.print(next + "->" + get(next) + " ");

        }
        System.out.println();

    }


}
