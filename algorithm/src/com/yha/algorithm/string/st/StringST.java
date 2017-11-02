package com.yha.algorithm.string.st;

/**
 * @author yha
 * @decription 以字符串为键的符号表
 * @create 2017-11-02 11:18
 **/
public abstract class StringST<Value> {

    /**
     * 向表中插入键值对（如果值为null则删除键key）
     * @param key
     * @param val
     */
    public abstract void put(String key, Value val);

    /**
     * 获取键key对应的值（如果不存在则返回null）
     * @param key
     * @return
     */
    public abstract Value get(String key);

    /**
     * 删除键key和对应的值
     * @param key
     */
    public abstract void delete(String key);

    /**
     * 表中是否保存着key的值
     * @param key
     * @return
     */
    public abstract boolean contains(String key);

    /**
     * 符号表是否为空
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * s的前缀中最长的键
     * @param s
     * @return
     */
    public abstract String longestPrefixOf(String s);

    /**
     * 所有以s为前缀的键
     * @param pre
     * @return
     */
    public abstract Iterable<String> keysWithPrefix(String pre);

    /**
     * 所有和s匹配的键（其中"."表示能够匹配任意一个字符）
     * @param s
     * @return
     */
    public abstract Iterable<String> keysThatMatch(String pat);

    /**
     * 键值对的数量
     * @return
     */
    public abstract int size();

    /**
     * 符号表中的所有键
     * @return
     */
    public abstract Iterable<String> keys();
}
