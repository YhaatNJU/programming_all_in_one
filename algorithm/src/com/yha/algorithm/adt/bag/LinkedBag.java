package com.yha.algorithm.adt.bag;

import com.yha.algorithm.adt.queue.Queue;

import java.util.Iterator;

/**
 * Author:yangsanyang
 * Time:2017/9/24 下午2:32.
 * Illustration:
 */
public class LinkedBag<Item> extends Bag<Item> {
    
    private class Node{
        Item item;
        Node next;
    
        public Node(Item item) {
            this.item = item;
        }
    }
    
    private Node first; //链表的首结点
    private int N = 0; //链表结点个数
    
    
    
    @Override
    public void add(Item item) {
        if (item == null)
            return;
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
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
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<Item>{
        
        private Node current = first;
    
        @Override
        public boolean hasNext() {
            return current != null;
        }
    
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    
    public static void main(String[] args){
    
        Bag<Integer> bag = new LinkedBag<>();
        bag.add(1);
        bag.add(9);
        bag.add(13);
        bag.add(7);
        bag.add(4);
        bag.add(6);
        bag.show();
    }
}
