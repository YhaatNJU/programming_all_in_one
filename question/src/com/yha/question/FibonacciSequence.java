package com.yha.question;

import java.util.Arrays;

/**
 * @author yha
 * @Description 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
 * @date 2017/11/12
 */
public class FibonacciSequence {

    private static int[] results;

    public int Fibonacci(int n) {
        int start = 0;
        if (results == null){
            results = new int[n+1];
        }else {
            if (n < results.length)
                return results[n];
            else {
                int tempLength = results.length;
                results = Arrays.copyOf(results, n+1);
                start = tempLength;
            }
        }
        while (start <= n){
            if (start == 0)
                results[start] = 0;
            else if (start == 1)
                results[start] = 1;
            else
                results[start] = results[start-2] + results[start-1];
            start++;
        }
        return results[n];
    }

    public static void main(String[] args){

        FibonacciSequence fs = new FibonacciSequence();
        System.out.println(fs.Fibonacci(6));
    }
}
