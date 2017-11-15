package com.yha.question;

/**
 * @author yha
 * @Description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @date 2017/11/15
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        int count = 1;
        int number = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] == number)
                count ++;
            else
                count --;
            if (count == 0){
                if (i == array.length - 1)
                    return 0;
                count = 1;
                number = array[i];
            }
        }
        count = 0;
        for (int i : array){
            if (i == number)
                count ++;
            if (count > array.length/2)
                return number;
        }
        return 0;
    }

    public static void main(String[] args){
        MoreThanHalfNum num = new MoreThanHalfNum();
        int[] ints = {1,2,3,2,2,2,5,4,2};
        System.out.println(num.MoreThanHalfNum_Solution(ints));
    }
}
