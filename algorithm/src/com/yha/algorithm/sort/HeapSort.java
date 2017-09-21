package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 堆排序
 * @create 2017-09-21 20:45
 **/
public class HeapSort extends Sort{


    private static void sink(Comparable[] a, int start, int end){

        int k = start;
        while (2*k < end){
            int j = k*2 + 1;
            if (j < end && less(a[j], a[j+1]))
                j++;
            if (!less(a[k], a[j]))
                break;
            exchange(a, k, j);
            k = j;
        }

    }


    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N/2 - 1; k >= 0; k--)
            sink(a, k, N-1);

        while (N > 1){
            exchange(a, 0, --N);
            sink(a, 0,  N-1);
        }
    }
}
