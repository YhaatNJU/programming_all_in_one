package com.yha.example.multiThreads.shellSort;

import com.yha.util.file.ArrayFileUtil;

/**
 * @author yha
 * @decription 使用串行方式的shell排序
 * @create 2017-10-06 21:30
 **/
public class SerialShellSort {

    public static void shellSort(int[] arr){
        //计算最大h值
        int h = 1;
        while (h < arr.length/3)
            h = h*3 + 1;
        while (h >= 1){
            for (int i = h; i < arr.length; i++){
                int temp = arr[i];
                int j = i;
                for (; j >= h && temp < arr[j-h]; j -= h)
                    arr[j] = arr[j-h];

                arr[j] = temp;
            }
            h = h/3;
        }
    }

    public static void shellSort2(int[] arr){
        //计算最大h值
        int h = 1;
        while (h < arr.length/3)
            h = h*3 + 1;
        while (h >= 1){
            for (int i = h; i < 2 * h && i < arr.length; i++){
                for (int j = i; j < arr.length; j += h){
                    int temp = arr[j];
                    int k = j;
                    for (; k >= h && temp < arr[k-h]; k -= h){
                        arr[k] = arr[k-h];
                    }
                    arr[k] = temp;
                }
            }

            h = h/3;
        }
    }

    public static void main(String[] args){
        int[] data = new int[50000000];
        ArrayFileUtil.readIntArray(data, "file/numbers/numbers.txt");
        long start = System.currentTimeMillis();
        shellSort2(data);
        long end = System.currentTimeMillis();
        System.out.println("Take time: " + (end - start) / 1000 + "seconds");
        ArrayFileUtil.writeIntArray(data, "file/numbers/numbers_sorted.txt", false);
    }

}
