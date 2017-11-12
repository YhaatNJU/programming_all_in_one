package com.yha.question;

import java.util.Arrays;

/**
 * @author yha
 * @Description 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @date 2017/11/12
 */
public class RectCover {

    private static int[] results;
    public int RectCover(int target) {
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
                results[start] = 0;
            else if (start == 1)
                results[start] = 1;
            else if (start == 2)
                results[target] = 2;
            else{
                results[start] = results[start-2]+ results[start-1];
            }
            start++;
        }

        return results[target];
    }
}
