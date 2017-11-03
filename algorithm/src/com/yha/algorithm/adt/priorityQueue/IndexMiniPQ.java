package com.yha.algorithm.adt.priorityQueue;

/**
 * @author yha
 * @decription 最小索引优先队列，关联的索引从0开始
 * @create 2017-09-23 22:57
 **/
public class IndexMiniPQ<Key extends Comparable<Key>>{

    private int N; // PQ中的元素数量
    private int[] pq; // 索引二叉堆，由1开始
    private int[] qp; // 逆序：qp[pq[i]] = pq[qp[i]] = i;
    private Key[] keys; // 有优先级之分的元素
    private final int capacity; //容量

    public IndexMiniPQ(int capacity){
        this.capacity = capacity;
        keys = (Key[]) new Comparable[capacity + 1];
        pq = new int[capacity + 1];
        qp = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++)
            qp[i] = -1;
    }


    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 队列是否包含元素，k从0开始
     * @param k 元素位置
     * @return
     */
    public boolean contains(int k){
        k++; //使得关联的整数可以为0
        if (k < 1 || k > capacity)
            throw new IllegalArgumentException();
        return qp[k] != -1;
    }

    /**
     * 将元素插入队列中的指定位置，k从0开始
     * @param k 位置
     * @param key 元素
     */
    public void insert(int k, Key key){

        if (contains(k)){
            change(k, key);
            return;
        }

        k++; //使得关联的整数可以为0

        N++;
        qp[k] = N;
        pq[N] = k;
        keys[k] = key;
        swim(N);


    }

    public int minIndex(){
        return pq[1];
    }

    /**
     * 修改队列中指定位置的元素
     * @param k 位置，从0开始
     * @param key 元素
     */
    public void change(int k, Key key){
        k++; //使得关联的整数可以为0
        if (k < 1 || k > capacity)
            throw new IllegalArgumentException();
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);

    }

    public Key min(){
        if (isEmpty())
            throw new Error("There is no element.");
        return keys[pq[1]];
    }

    public int delMin(){
        if (isEmpty())
            throw new Error("There is no element.");
        int indexOfMin = pq[1];
        exchange(1, N);
        qp[pq[N]] = -1;
        keys[pq[N]] = null;
        pq[N] = -1;
        N--;
        sink(1);

        indexOfMin--; //使得关联的整数可以为0

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

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean large(int i, int j){
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    public int size(){
        return N;
    }

    public void show(){
        for (int i = 1; i <= N; i++){
            System.out.print(keys[pq[i]] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){



        int[] data = {9, 2, 3, 6, 4, 7, 8, 11, 1, 5,};

        int size = 5;
        IndexMiniPQ<Integer> pq = new IndexMiniPQ<>(size);
        for (int i = 0; i < data.length; i++){
            pq.insert(i >= size ? pq.delMin() : i, data[i]);
        }

        pq.show();

        while (!pq.isEmpty()){
            System.out.print(pq.min() + " ");
            pq.delMin();
        }

    }

}
