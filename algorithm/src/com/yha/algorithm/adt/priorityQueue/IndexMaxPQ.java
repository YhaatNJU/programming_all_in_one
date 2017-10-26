package com.yha.algorithm.adt.priorityQueue;

/**
 * @author yha
 * @decription 最大索引优先队列
 * @create 2017-10-26 23:08
 **/
public class IndexMaxPQ<Key extends Comparable<Key>> {

    private int N; // PQ中的元素数量
    private int[] pq; // 索引二叉堆，由1开始
    private int[] qp; // 逆序：qp[pq[i]] = pq[qp[i]] = i;
    private Key[] keys; // 有优先级之分的元素

    public IndexMaxPQ(int maxN){
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

    public void change(int k, Key key){
        if (k < 1 || k >= keys.length)
            throw new IllegalArgumentException();
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);

    }

    public void insert(int k, Key key){
        if (k < 1 || k >= keys.length)
            throw new IllegalArgumentException();
        if ((N + 1) >= keys.length)
            throw new Error("There is no space for new element.");
        if (contains(k)){
            change(k, key);
            return;
        }

        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);
    }

    public int maxIndex(){
        if (isEmpty())
            throw new Error("There is no element.");
        return pq[1];
    }

    public Key max(){
        if (isEmpty())
            throw new Error("There is no element.");
        return keys[pq[1]];
    }

    public int delMax(){
        if (isEmpty())
            throw new Error("There is no element.");
        int indexOfMin = pq[1];
        exchange(1, N);
        qp[pq[N]] = -1;
        keys[pq[N]] = null;
        pq[N] = -1;
        N--;
        sink(1);

        return indexOfMin;
    }

    public int size(){
        return N;
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


    private boolean less(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exchange(int i, int j){
        int temp = pq[j];
        pq[j] = pq[i];
        pq[i] = temp;

        qp[pq[j]] = i;
        qp[pq[i]] = j;
    }

    public static void main(String[] args){

        int[] data = {9, 2, 3, 6, 4, 7, 8, 11, 1, 5,};

        int size = 5;
        IndexMaxPQ<Integer> pq = new IndexMaxPQ<>(size);
        for (int i = 0; i < data.length; i++){
            pq.insert(i >= size ? pq.delMax() : i + 1, data[i]);
        }

        while (!pq.isEmpty()){
            System.out.print(pq.max() + " ");
            pq.delMax();
        }
    }

}
