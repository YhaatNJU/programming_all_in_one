package com.yha.question;

/**
 * @author yha
 * @Description 统计一个数字在排序数组中出现的次数。
 * @date 2017/11/16
 */
public class NumberOfKInArray {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length < 1)
            return 0;
        if (k < array[0])
            return 0;
        if (k > array[array.length - 1])
            return 0;
        int begin = 0;
        int end = array.length;
        int position = -1;
        while (begin < end){
            int mid = (begin + end) / 2;
            if (begin == mid){
                if (k == array[begin]){
                    position = begin;
                    break;
                }
                if (k == array[end]){
                    position = end;
                    break;
                }
                break;
            }
            if (k > array[mid]){
                begin = mid;
            }else if (k < array[mid]){
                end = mid;
            }else {
                position = mid;
                break;
            }
        }
        if (position == -1)
            return 0;
        int times = 1;
        for (int i = position - 1; i >= 0 && array[i] == k; i--)
            times++;
        for (int i = position + 1; i < array.length && array[i] == k; i++)
            times++;
        return times;
    }

    public static void main(String[] args){

        NumberOfKInArray number = new NumberOfKInArray();
        int[] array = {1,2,3,4,5,5,5,5,6,7,8,10};
        System.out.println(number.GetNumberOfK(array,9));
    }
}
