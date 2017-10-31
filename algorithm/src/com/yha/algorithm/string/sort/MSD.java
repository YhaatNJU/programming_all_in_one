package com.yha.algorithm.string.sort;

import java.util.Arrays;

/**
 * @author yha
 * @decription 高位优先(MSD,Most Significant Digit first)的字符串排序
 * @create 2017-10-31 22:42
 **/
public class MSD {

    /**
     * 基数
     */
    private static int R = 256; //基数

    /**
     * 小数组切换的阈值
     */
    private static final int M = 15; //小数组的切换阈值

    /**
     * 数组分类的辅助数组
     */
    private static String[] aux; //数组分类的辅助数组

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
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }


    private static int times = 0;
    /**
     * 使用键索引计数法排序的高位优先算法的核心排序算法
     * @param a 待排序的字符串数组
     * @param low 待排序的字符串开始下标
     * @param high 待排序的字符串结束下标
     * @param d 用来比较的字符串中字符的位置
     */
    private static void sort(String[] a, int low, int high, int d){
        //以第d个字符为键将a[low]至a[high]排序
        if (high <= low + M){
            insertSort(a, low, high, d);
            return;
        }
        /*if (low >= high)
            return;*/

        int[] count = new int[R+2];
        //计算频率
        for (int i = low; i <= high; i++)
            count[charAt(a[i],d) + 2]++;

        //将频率转换为索引
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        //数组分类
        for (int i = low; i <= high; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        //回写
        for (int i = low; i <= high; i++)
            a[i] = aux[i - low];

        //递归的以每个字符为键进行排序
        for (int r = 0; r < R; r++)
            sort(a, low + count[r], low + count[r+1] - 1, d+1);
    }

    /**
     * 为字符串数组定制的使用字符串特定位置字符进行比较的插入排序
     * @param a 待排序的字符串数组
     * @param low 待排序的字符串开始下标
     * @param high 待排序的字符串结束下标
     * @param d 用来比较的字符串中字符的位置
     */
    private static void insertSort(String[] a, int low, int high, int d){
        if (low >= high)
            return;
        boolean end = d < a[low].length() ? false : true;
        for (int i = low + 1; i <= high; i++){
            int j = i;
            String temp = a[i];
            if (d < a[i].length()){
                end = false;
            }
            int tempIndex = charAt(temp, d);
            for (; j > low && tempIndex < charAt(a[j-1],d); j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
        if (!end)
            insertSort(a, low, high, d+1);

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
