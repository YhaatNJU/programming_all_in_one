package com.yha.algorithm.adt.priorityQueue;

/**
 * @author yha
 * @decription 最大优先队列（使用数组实现）
 * @create 2017-09-20 22:52
 **/
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq; //基于堆的完全二叉树
    private int N = 0; //存储于pq[1..N], pq[0[没有使用

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        exchange(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    /**
     * 比较两个下标对应的pq[]中值的大小
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * 交换两个下标对应的pq[]中的值
     * @param i
     * @param j
     */
    private void exchange(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 将较大元素上浮到合适位置
     * @param k
     */
    private void swim(int k){
        while (k > 1 && less(k/2, k)){
            exchange(k/2, k);
            k = k/2;
        }
    }

    /**
     * 将较小元素下沉到合适位置
     * @param k
     */
    private void sink(int k){
        while (2*k <= N){
            int j = 2*k;
            if (j < N && less(j, j+1))
                j++;
            if (!less(k, j))
                break;
            exchange(k, j);
            k = j;
        }
    }

    public void show(){
        for (int i = 1; i < N+1; i++){
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

}
