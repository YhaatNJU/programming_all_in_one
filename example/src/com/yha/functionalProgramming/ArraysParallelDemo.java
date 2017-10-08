package com.yha.functionalProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yha
 * @decription 包含JDK8的Arrays针对数组的并行操作示例
 * @create 2017-10-08 14:44
 **/
public class ArraysParallelDemo {

    //实验并行化数组操作初始化数组
    public static double[] parallelInitialize(int size){
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> 0.1);
        return values;
    }

    //计算简单滑动平均数
    public static double[] simpleMovingAverage(double[] values, int n){
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length)
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n;
                })
                .toArray();
    }

    public static void main(String[] args){
        double[] data = {1,3,4,5,3,7,1.0};
        double[] result = simpleMovingAverage(data, 3);
        Arrays.stream(result).forEach(System.out::println);
    }

}
