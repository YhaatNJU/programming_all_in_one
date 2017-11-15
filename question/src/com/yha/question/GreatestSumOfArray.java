package com.yha.question;

/**
 * @author yha
 * @Description 找出一个包含负数的数组的最大子数组和
 * @date 2017/11/15
 */
public class GreatestSumOfArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return Integer.MIN_VALUE;
        int total = array[0];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++){
            if (total >= 0)
                total+=array[i];
            else
                total = array[i];
            if (total > maxSum)
                maxSum = total;
        }
        return maxSum;
    }

    public static void main(String[] args){

        GreatestSumOfArray great = new GreatestSumOfArray();
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(great.FindGreatestSumOfSubArray(array));
    }
}
