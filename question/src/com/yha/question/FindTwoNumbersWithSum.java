package com.yha.question;

import java.util.ArrayList;

/**
 * @author yha
 * @Description 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @date 2017/11/17
 */
public class FindTwoNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null)
            return null;
        if (array.length == 0 && sum == 0)
            return new ArrayList<>();
        if (array.length < 2)
            return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int head = 0;
        int tail = array.length - 1;
        while (head <= tail){
            if (array[head] + array[tail] == sum){
                arrayList.add(array[head]);
                arrayList.add(array[tail]);
                return arrayList;
            }
            if (array[head] + array[tail] < sum)
                head++;
            else
                tail--;
        }

        return arrayList;

    }
}
