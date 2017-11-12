package com.yha.question;

import java.util.Arrays;

/**
 * @author yha
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @date 2017/11/12
 */
public class JumpFloor {

    private static int[] results;

    public int JumpFloor(int target) {

        int start = 0;
        if (results == null)
            results = new int[target+1];
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
            else
                results[start] = results[start-2] + results[start-1];
            start++;
        }

        return results[target];
    }
}
