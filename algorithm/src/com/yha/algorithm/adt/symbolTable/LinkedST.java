package com.yha.algorithm.adt.symbolTable;

import java.util.Iterator;

/**
 * @author yha
 * @decription 无序符号表的链表实现
 * @create 2017-09-22 16:47
 **/
public class LinkedST<Key, Value>
        extends SymbolTable<Key, Value> {

    private class Node{
        //链表节点的定义
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private int N = 0;

    private Node first; //链表首结点

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            return;
        //查找给定的键，找到则更新其值，否则在表中新建结点
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)){
                if (val == null){ //val未空则删除对应的键
                    delete(key);
                    return;
                }
                x.val = val; //命中，更新
                return;
            }
        first = new Node(key, val, first);  //未命中，新建结点
        N++;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            return null;
        //查找给定的键，返回相关联的值
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;

        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null)
            return;
        for (Node x = first, pre = null; x != null; pre = x, x = x.next){
            if (key.equals(x.key)){
                if (pre == null){
                    first = x.next;
                }else {
                    pre.next = x.next;
                }
                N--;
                return;
            }
        }
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
        return ()->new LinkedIterator();
        /*return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new LinkedIterator(1);
            }
        };*/
    }

    private class LinkedIterator implements Iterator<Key>{

        private Node next = first;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Key next() {
            Node current = next;
            next = next.next;
            return current.key;
        }
    }


}
