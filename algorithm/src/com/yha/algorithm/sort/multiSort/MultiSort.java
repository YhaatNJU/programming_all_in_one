package com.yha.algorithm.sort.multiSort;

import java.util.Comparator;

/**
 * @author yha
 * @decription 可以采用多种剑值比较的排序类
 * @create 2017-09-21 21:51
 **/
public class MultiSort {

    public static void sort(Object[] a, Comparator c){

        //以插入排序为例

        int N = a.length;
        for (int i = 1; i < N; i++){
            Object temp = a[i];
            int j = i;
            for (; j > 0 && less(c, temp, a[j-1]); j--)
                a[j] = a[j-1];
            a[j] = temp;
        }

    }


    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v, w) < 0;
    }

    private static void exchange(Object[] a, int i, int j){
        Object o = a[i];
        a[i] = a[j];
        a[j] = o;
    }

}
