package com.yha.algorithm.adt.symbolTable;

import com.yha.algorithm.adt.queue.Queue;

import java.util.Iterator;

/**
 * @author yha
 * @decription 基于拉链法的散列符号表
 * @create 2017-09-24 0:39
 **/
public class SeparateChainingHashST<Key, Value> extends SymbolTable<Key, Value> {

    private int N; //键值对总数
    private int M; //散列表大小
    private LinkedST<Key, Value>[] st; //存放链表对象的数组

    public SeparateChainingHashST(int m) {
        //创建M条链表
        this.M = m;
        st = new LinkedST[M];
        for (int i = 0; i < M; i++)
            st[i] = new LinkedST<>();

    }



    public SeparateChainingHashST() {
        this(997);
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            return;
        if (val == null){
            delete(key);
            return;
        }
        st[hash(key)].put(key, val);
        N++;
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void delete(Key key) {
        if (key == null)
            return;
        if (contains(key))
            N--;
        st[hash(key)].delete(key);
    }

    @Override
    public boolean contains(Key key) {
        if (key == null)
            return false;
        return st[hash(key)].contains(key);
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
        for (int i = 0; i < M; i ++){
            Iterator<Key> iterator = st[i].keys().iterator();
            while (iterator.hasNext()){
                queue.enqueue(iterator.next());
                left--;
            }
            if (left == 0)
                return;
        }
    }


    public static void main(String[] args){

        SeparateChainingHashST<Integer, String> hashST = new SeparateChainingHashST<>();
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
