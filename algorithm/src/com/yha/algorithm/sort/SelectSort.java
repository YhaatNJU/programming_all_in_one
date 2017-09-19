package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 选择排序
 * 首先找到数组中最小的元素，将它和数组的第一个元素交换位置（如果第一个元素就是最小的，则和自己交换）。
 * 再次，在剩下的元凶中找到最小的元素，将它与数组中的第二个元素交换位置。
 * 如此往复，直到将整个数组排序
 *
 * 性能：
 *  最快：平方级别
 *  最慢：平方级别
 *  平均：平方级别
 * @create 2017-09-19 23:05
 **/
public class SelectSort extends Sort {

    public static void sort(Comparable[] a){
        //将a[]按照升序排列
        int N = a.length;
        for (int i = 0; i < N; i++){
            //将a[i]和a[i+1..N-1]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exchange(a, i, min);
        }
    }
}
