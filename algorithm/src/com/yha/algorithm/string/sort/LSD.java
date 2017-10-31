package com.yha.algorithm.string.sort;

import java.util.Arrays;

/**
 * @author yha
 * @decription 低位优先(LSD,Least Significant Digit first)的字符串排序，适合等长的字符串数组排序，以键索引计数排序法为基础
 * @create 2017-10-30 23:00
 **/
public class LSD {

    /**
     * 低位优先的字符串排序
     * @param a 待排序的字符串，必须等长
     * @param w 用来排序的字符串个数
     */
    public static void sort(String[] a, int w){

        //通过前w个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--){
            //根据第d个字符用键索引计数法排序

            int[] count = new int[R+1];
            //计数出现频率
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;

            //将频率转换为索引
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            //将元素分类
            for (int i = 0;  i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            //回写
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void main(String[] args){

        String[] strings = {
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"
        };
        sort(strings, 7);
        Arrays.asList(strings).stream().forEach(System.out::println);
    }

}
