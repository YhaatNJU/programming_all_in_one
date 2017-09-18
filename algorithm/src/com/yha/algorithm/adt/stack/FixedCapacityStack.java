package com.yha.algorithm.adt.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author yha
 * @decription 固定容量的泛型栈
 * @create 2017-09-18 11:18
 **/
public class FixedCapacityStack<T> implements Iterable{

    private T[] aT;

    private int iN = 0;

    public FixedCapacityStack(int cap) {
        aT = (T[]) new Object[cap];
    }

    public boolean isEmpty(){
        return iN == 0;
    }


    public boolean push(T oT){
        if (isFull()){
            return false;
        }else {
            aT[iN++] = oT;
            return true;
        }
    }

    public T pop(){
        if (iN == 0){
            return null;
        }

        //避免对象游离浪费内存，将弹出后数组中的对象设为NULL
        T re = aT[--iN];
        aT[iN] = null;
        return re;
    }

    public boolean isFull(){
        return iN == aT.length;
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private  int i = iN;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (i == 0){
                throw new NoSuchElementException();
            }
            return aT[--i];
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
