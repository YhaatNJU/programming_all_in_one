package com.yha.algorithm.sort;

/**
 * Author:yha
 * @description: 希尔排序
 * Time:2017/9/20 下午8:32.
 * Illustration:
 */
public class ShellSort extends Sort{
    
    public static void sort(Comparable[] a){
        //将数组a[]按照升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3)
            h = 3*h + 1;// 1， 4， 13，40， 121， 364， 1093， ...
        while (h >= 1){
            //将数组变为h有序
            for (int i = h; i < N; i++){
                //局部使用插入排序
                int j = i;
                Comparable temp = a[i];
                for (; j >= h && less(temp, a[j-h]); j -= h)
                    a[j] = a[j-h];
                a[j] = temp;
            }
            
            h = h/3;
        }
    }
}
