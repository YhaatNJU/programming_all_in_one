package com.yha.algorithm.adt.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yha
 * @decription 可变容量的栈
 * @create 2017-09-18 12:24
 **/
public class ResizingArrayStack<Item> implements Iterable{

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    private void resize(int max){

        Item[] aTemp = (Item[]) new Object[max];
        for (int i = 0; i < N; i ++){
            aTemp[i] = a[i];
        }
        a = aTemp;
    }

    public void push(Item item){
        if (N == a.length)
            resize(a.length * 2);

        a[N++] = item;
    }

    public Item pop(){
        if (N <= 0)
            throw new NoSuchElementException();

        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return item;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private  int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (i == 0){
                throw new NoSuchElementException();
            }
            return a[--i];
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
