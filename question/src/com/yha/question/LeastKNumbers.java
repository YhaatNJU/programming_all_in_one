package com.yha.question;

import java.util.ArrayList;

/**
 * @author yha
 * @Description 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @date 2017/11/15
 */
public class LeastKNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || k < 1 || input.length < k)
            return new ArrayList<>();
        int[] numbers = new int[k];
        for (int i = 0; i < k; i++)
            numbers[i] = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++){
            insert(numbers, input[i]);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i : numbers)
            integers.add(i);
        return integers;
    }

    private void insert(int[] numbers, int target){
        int index = numbers.length - 1;
        while (numbers[index] > target && index > 0){
            if (target >= numbers[index-1])
                numbers[index] = target;
            else
                numbers[index] = numbers[--index];
        }
        if (target < numbers[0])
            numbers[0] = target;
    }

    public static void main(String[] args){

        LeastKNumbers numbers = new LeastKNumbers();
        int[] input = {4,5,1,6,2,7,3,8};
        numbers.GetLeastNumbers_Solution(input,4).forEach(System.out::println);
    }
}
