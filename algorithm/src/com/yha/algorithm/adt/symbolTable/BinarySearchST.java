package com.yha.algorithm.adt.symbolTable;

import java.util.Iterator;

/**
 * @author yha
 * @decription 基于有序数组的二分查找的有序符号表
 * @create 2017-09-22 18:54
 **/
public class BinarySearchST<Key extends Comparable<Key>, Value>
        extends OrderedSymbolTable<Key, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N = 0;

    public BinarySearchST(int capacity) {
        if (capacity < 1)
            capacity = 1;
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N-1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if (keys[i].compareTo(key) == 0)
            return keys[i];
        if (i <= 0)
            return null;
        return keys[i-1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public int rank(Key key) {
        int low = 0, high = N-1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                high = mid - 1;
            else if (cmp > 0)
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }

    @Override
    public Key select(int k) {
        if (k > N-1)
            return null;
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        int lo = rank(low);
        if (lo >= N)
            return null;

        int hi = rank(high);
        if (hi >= N)
            return null;
        return ()->new ArrayIterator(lo, hi);
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            return;
        if (val == null){
            delete(key);
            return;
        }
        //查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            vals[i] = val;
            return;
        }
        if (N == keys.length){
            resize(keys.length*2);
        }
        for (int j = N; j > i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;

    }

    @Override
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;

    }

    @Override
    public void delete(Key key) {
        if (key == null)
            return;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0){
            for (int j = i; j < N-1; j++){
                keys[j] = keys[j+1];
                vals[j] = vals[j+1];
            }
            N--;
            if (N > 0 &&N == keys.length / 4){
                resize(keys.length/2);
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

    private void resize(int max){

        Key[] tempKeys = (Key[]) new Comparable[max];
        Value[] tempVals = (Value[]) new Comparable[max];
        for (int i = 0; i < N; i++){
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }

        keys = tempKeys;
        vals = tempVals;
    }

    private class ArrayIterator implements Iterator<Key> {

        private int next;
        private int end;


        public ArrayIterator(int low, int high) {
            this.next = low;
            this.end = high < N-1 ? high : N-1;
        }

        @Override
        public boolean hasNext() {
            return next <= end;
        }

        @Override
        public Key next() {
            return keys[next++];
        }
    }
}
