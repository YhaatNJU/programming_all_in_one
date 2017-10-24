package com.yha.algorithm.adt.priorityQueue;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author yha
 * @decription 索引优先队列
 * @create 2017-09-23 22:57
 **/
public class IndexMiniPQ<Key extends Comparable<Key>>{

    private int N; // PQ中的元素数量
    private int[] pq; // 索引二叉堆，由1开始
    private int[] qp; // 逆序：qp[pq[i]] = pq[qp[i]] = i;
    private Key[] keys; // 有优先级之分的元素

    public IndexMiniPQ(int maxN){
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }


    public boolean isEmpty(){
        return N == 0;
    }

    public boolean contains(int k){
        if (k < 1 || k >= keys.length)
            throw new IllegalArgumentException();
        return qp[k] != -1;
    }

    public void insert(int k, Key key){
        if (k < 1 || k >= keys.length)
            throw new IllegalArgumentException();
        if ((N + 1) >= keys.length)
            throw new Error("There is no space for new element.");
        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
        show();

    }

    public int minIndex(){
        return pq[1];
    }

    public void change(int k, Key key){
        if (k < 1 || k >= keys.length)
            throw new IllegalArgumentException();
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);

    }

    public Key min(){
        return keys[pq[1]];
    }

    public int delMin(){
        if (isEmpty())
            throw new Error("There is no element.");
        int indexOfMin = pq[1];
        exchange(1, N--);
        sink(1);
        keys[pq[N+1]] = null;
        qp[pq[N+1]] = -1;
        return indexOfMin;
    }

    /**
     * 将较小元素上浮到合适位置
     * @param k
     */
    private void swim(int k){
        while (k > 1 && large(k/2, k)){
            exchange(k/2, k);
            k = k/2;
        }
    }

    /**
     * 将较大元素下沉到合适位置
     * @param k
     */
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && large(j, j+1))
                j++;
            if (!large(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }

    private void exchange(int i, int j){
        int temp = pq[j];
        pq[j] = pq[i];
        pq[i] = temp;

        temp = qp[pq[j]];
        qp[pq[j]] = qp[pq[i]];
        qp[pq[i]] = temp;
    }

    private boolean large(int i, int j){
        return keys[i].compareTo(keys[j]) > 0;
    }

    public int size(){
        return N;
    }

    public void show(){
        for (int i = 1; i < pq.length; i++){
            System.out.print(keys[pq[i]] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        IndexMiniPQ<Integer> pq = new IndexMiniPQ<>(5);
        pq.insert(1,4);
        pq.insert(2, 3);
        pq.insert(3, 2);
        pq.insert(4,1);
        pq.insert(5, 5);
        pq.show();
        pq.delMin();
        pq.insert(5, 6);
        pq.show();
        pq.delMin();
        pq.show();
        pq.delMin();
        pq.show();
    }

}
