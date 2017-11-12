package com.yha.question;

import java.util.Arrays;

/**
 * @author yha
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @date 2017/11/12
 */
public class JumpFllorII {

    private static long[] results;

    public long JumpFloorII(int target) {
        int start = 0;
        if (results == null)
            results = new long[target+1];
        else {
            if (target < results.length)
                return results[target];
            else {
                start = results.length;
                results = Arrays.copyOf(results, target+1);
            }
        }
        while (start <= target){
            if (start == 0)
                results[start] = 1;
            else if (start == 1)
                results[start] = 1;
            else{
                int sum = 0;
                for (int i = 0; i < start; i++)
                    sum += results[i];
                results[start] = sum;
            }
            start++;
        }

        return results[target];
    }

    public static void main(String[] args){
        JumpFllorII ii = new JumpFllorII();
        System.out.println(System.currentTimeMillis());
        System.out.println(ii.JumpFloorII(30));
        System.out.println(System.currentTimeMillis());
        System.out.println(ii.JumpFloorII(29));
        System.out.println(System.currentTimeMillis());
    }

}
