package com.yha.algorithm.adt.symbolTable;

import com.yha.algorithm.adt.queue.Queue;

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

    public LinearProbingHashST(int m) {
        M = m;
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
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M){
            if (keys[i].equals(key))
                return vals[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key))
            return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8)
            resize(M/2);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        keys(queue);
        return queue;
    }

    private void keys(Queue<Key> queue){

        int left = N;
        for (int i = 0; i < M && left > 0; i ++){
            if (keys[i] != null){
                queue.enqueue(keys[i]);
                left --;
            }
        }
    }

    /**
     * 改变散列表大小
     * @param max
     */
    private void resize(int max){

        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(max);

        for (int i = 0; i < M; i++){
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        }
        M = max;
        keys = t.keys;
        vals = t.vals;

    }

    public static void main(String[] args){

        LinearProbingHashST<Integer, String> hashST = new LinearProbingHashST<>();
        hashST.put(23, "fadf");
        hashST.put(124, "qweljqwle");
        hashST.put(7, "4faoer");
        hashST.put(91, "eqqwerl");
        hashST.put(1314, "1234123");
        hashST.put(1088, "41234asdfl");
        hashST.show();
        hashST.delete(7);
        hashST.show();
        System.out.println(hashST.get(91));


    }
}
