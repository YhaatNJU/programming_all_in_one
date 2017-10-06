package com.yha.example.multiThreads.oddEvenSort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author yha
 * @decription 使用串行方式的奇偶交换排序
 * @create 2017-10-05 16:39
 **/
public class SerialOddEvenSort {

    public static void oddEvenSort(int[] data){
        int exchFlag = 1, start = 0;
        while (exchFlag == 1 || start == 1){
            exchFlag = 0;
            for (int i = start; i < data.length - 1; i += 2){
                if (data[i] > data[i + 1]){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                    exchFlag = 1;
                }
            }
            if (start == 0)
                start = 1;
            else
                start = 0;
        }

    }



}
