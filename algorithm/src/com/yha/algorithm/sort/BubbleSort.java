package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 冒泡排序
 * @create 2017-10-13 21:13
 **/
public class BubbleSort extends Sort{


    public static void sort(Comparable[] a){

        if (a == null || a.length < 2)
            return;

        //将a从大到小排序（较小的冒到后面去了

        for (int i = a.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (less(a[j+1], a[j])){
                    exchange(a, j+1, j);
                }
            }

        }
    }



}
