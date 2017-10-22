package com.yha.algorithm.adt.symbolTable;

/**
 * @author yha
 * @decription 有序符号表基类
 * @create 2017-09-22 16:23
 **/
public abstract class OrderedSymbolTable<Key extends Comparable<Key>, Value>
        extends SymbolTable<Key,Value>{

    /**
     * 最小的键
     * @return
     */
    public abstract Key min();

    /**
     * 最大的键
     * @return
     */
    public abstract Key max();

    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    public abstract Key floor(Key key);

    /**
     * 大于等于key的最小键
     * @param key
     * @return
     */
    public abstract Key ceiling(Key key);

    /**
     * 小于key键的数量
     * @param key
     * @return
     */
    public abstract int rank(Key key);

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    public abstract Key select(int k);

    /**
     * 删除最小的键（便捷实现）
     */
    public void deleteMin(){
        delete(min());
    }

    /**
     * 删除最大的键（便捷实现）
     */
    public void deleteMax(){
        delete(max());
    }

    /**
     * [low..high]直接键的数量（便捷实现）
     * @param low
     * @param high
     * @return
     */
    public int size(Key low, Key high){
        if (high.compareTo(low) < 0)
            return 0;
        else if (contains(high))
            return rank(high) - rank(low) + 1;
        else
            return rank(high) - rank(low);
    }

    /**
     * [low..high]之间的所有键，已排序
     * @param low
     * @param high
     * @return
     */
    public abstract Iterable<Key> keys(Key low, Key high);

    /**
     * 表中的所有键，已排序（便捷实现）
     * @return
     */
    public Iterable<Key> keys(){
        return keys(min(), max());
    }



}
