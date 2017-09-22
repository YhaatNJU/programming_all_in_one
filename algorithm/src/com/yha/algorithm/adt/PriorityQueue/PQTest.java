package com.yha.algorithm.adt.priorityQueue;

/**
 * @author yha
 * @decription 优先队列测试类
 * @create 2017-09-20 23:18
 **/
public class PQTest {

    public static void main(String[] args){

        MinPQ<Integer> pq = new MinPQ<>(100);
        pq.insert(2);
        pq.insert(1);
        pq.insert(6);
        pq.show();
        pq.insert(4);
        pq.show();
        pq.insert(5);
        pq.show();
        pq.delMin();
        pq.show();
        pq.delMin();
        pq.insert(3);
        pq.show();

    }

}
