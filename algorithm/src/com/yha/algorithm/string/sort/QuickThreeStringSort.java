package com.yha.algorithm.string.sort;

import java.util.Arrays;

/**
 * @author yha
 * @decription 三向字符串快速排序
 * @create 2017-11-02 10:52
 **/
public class QuickThreeStringSort {

    /**
     * 获取字符串中指定位置的字符，超过数组长度时返回-1
     * @param s 目标字符串
     * @param d 位置
     * @return
     */
    private static int charAt(String s, int d){
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(String[] a){
        sort(a, 0, a.length-1, 0);
    }


    /**
     * 三向快速排序的核心
     * @param a
     * @param low
     * @param high
     * @param d
     */
    private static void sort(String[] a, int low, int high, int d){
        if (high <= low)
            return;
        int lt = low, gt = high;
        int v = charAt(a[low], d);
        int i = low + 1;
        while (i <= gt){
            int t = charAt(a[i], d);
            if (t < v)
                exch(a, lt++, i++);
            else if (t > v)
                exch(a, i, gt--);
            else
                i++;
        }
        // a[low...lt-1] < v = a[lt...gt] < a[gt_1...high]
        sort(a, low, lt-1, d);
        if (v >= 0)
            sort(a, lt, gt, d+1);
        sort(a, gt+1, high, d);
    }


    private static void exch(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        String[] a = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "seashore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells"
        };
        sort(a);
        Arrays.asList(a).stream().forEach(System.out::println);
    }

}
