package com.yha.functionalProgramming;

import java.util.Arrays;

/**
 * @author yha
 * @decription
 * @create 2017-10-07 14:25
 **/
public class Test {

    public static void main(String[] args){
        //testPrintln();
        //testInvariance();
        testOdd();
    }

    public static void testPrintln(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void testInvariance(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).map((x) -> x = x + 1).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void testOdd(){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).filter(x -> x % 2 == 1).forEach(System.out::println);

    }

}
