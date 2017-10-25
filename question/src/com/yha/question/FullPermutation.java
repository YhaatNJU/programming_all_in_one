package com.yha.question;

/**
 * @author yha
 * @decription 输出n个数的全排列
 * @create 2017-10-25 21:05
 **/
public class FullPermutation {

    private static int count;

    public static void main(String[] args){

        int n = 8;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++)
            nums[i-1] = i;
        count = 0;
        perm(nums, 0);
        System.out.println("count:" + count);
    }

    public static void perm(int[] nums, int index){
        if (index >= nums.length)
            return;
        if (index == nums.length - 1){
            printArray(nums);
            count++;
            return;
        }

        for (int i = index; i < nums.length; i++){

            exch(nums, i, index);
            perm(nums, index + 1);
            exch(nums, i, index);
        }

    }

    private static void printArray(int[] nums){
        for (int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void exch(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
