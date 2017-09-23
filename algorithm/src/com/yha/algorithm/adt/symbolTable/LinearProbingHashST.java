package com.yha.algorithm.adt.symbolTable;

/**
 * @author yha
 * @decription 基于线性探测的散列无序符号表
 * @create 2017-09-24 1:28
 **/
public class LinearProbingHashST<Key, Value> extends SymbolTable<Key, Value> {

    private int N; //符号表中键值对的总数
    private int M = 16; //线性探测表的大小
    private Key[] keys; //键
    private Value[] vals; //值

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(Key key, Value val) {
        if (N >= M/2)
            resize(2*M); //将M加倍
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M){
            if (keys[i].equals(key)){
                vals[i] = val;
                return;
            }

            //todo
            //全部都不为空，死循环？
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    /**
     * 改变散列表大小
     * @param max
     */
    private void resize(int max){

        Key[] tempKeys = (Key[]) new Object[max];
        Value[] tempVals = (Value[]) new Object[max];

        boolean isExpand = max > M;
        for (int i = 0; i < M; i++){
            if (!isExpand){
                tempKeys[i%M] = keys[i%M];
                tempVals[i%M] = vals[i%M];
            }else {
                tempKeys[i] = keys[i];
                tempVals[i] = vals[i];
            }
        }
        M = max;
        keys = tempKeys;
        vals =tempVals;

    }
}
