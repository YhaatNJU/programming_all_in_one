package com.yha.functionalProgramming;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yha
 * @decription 包含一些并行执行的流示例
 * @create 2017-10-08 17:40
 **/
public class ParallelStreamDemo {

    public static int parallelSumOfSquares(IntStream range){
        return range.parallel()
                .map(x -> x * x)
                .sum();
    }


    public static int[] parallelInitialize(int size){
        int[] value = new int[size];
        Arrays.parallelSetAll(value, i -> i);
        return value;
    }


    public static void main(String[] args){
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        IntStream range = IntStream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        System.out.println(parallelSumOfSquares(range));
    }

}
