package com.yha.algorithm.adt.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yha
 * @decription 使用单向链表实现的栈
 * @create 2017-09-18 12:55
 **/
public class Stack<Item> implements Iterable<Item>{


    private class Node{
        Item item;
        Node next;
    }

    private Node first;  //栈顶
    private int N; //元素的数量

    public boolean isEmpty(){
        return first == null;  //或者N==0
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        if (first == null)
            throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

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

        Stack<String> stringStack = new Stack<>();
        stringStack.push("be.");
        stringStack.push("to ");
        stringStack.push("not ");
        stringStack.push("or ");
        stringStack.push("be ");
        stringStack.push("To ");
        for (String s : stringStack){
            System.out.print(s);
        }

    }
}
