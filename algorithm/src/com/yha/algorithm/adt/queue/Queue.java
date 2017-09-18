package com.yha.algorithm.adt.queue;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yha
 * @decription 使用单向链表实现的队列
 * @create 2017-09-18 13:27
 **/
public class Queue<Item> implements Iterable<Item>{

    private class Node{
        Item item;
        Node next;
    }

    private Node first; //指向最早添加的结点的链接
    private Node last; //指向最晚添加的结点的链接
    private int N; // 队列中的元素数量

    public boolean isEmpty(){
        return first == null; //或者 N == 0
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new OrderIterator();
    }

    private class OrderIterator implements Iterator<Item> {

        Node nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Item next() {
            if (nextNode == null){
                throw new NoSuchElementException();
            }
            Item item = nextNode.item;
            nextNode = nextNode.next;
            return item;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args){

        Queue<String> queue = new Queue<>();
        queue.dequeue();
        queue.enqueue("To ");
        queue.enqueue("be ");
        queue.enqueue("or ");
        queue.enqueue("not ");
        queue.enqueue("to ");
        queue.enqueue("be.");
        for (String s : queue){
            System.out.print(s);
        }
    }

}
