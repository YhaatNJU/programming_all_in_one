package com.yha.question;

/**
 * @author yha
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @date 2017/11/12
 */
public class ReorderArray {
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2)
            return;

        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++){
            ints[i] = array[i];
        }
        int index = 0;
        for (int i = 0; i < ints.length; i++){
            if ((ints[i] & 1) == 1){
                array[index] = ints[i];
                index++;
            }
        }
        for (int i = 0; i < ints.length; i++){
            if ((ints[i] & 1) == 0){
                array[index] = ints[i];
                index++;
            }

        }

    }

    public static void main(String[] args){

        ReorderArray reorderArray = new ReorderArray();
        int[] data = {1,2,3,4,5,6,7,8};
        reorderArray.reOrderArray(data);
        for (int i : data)
            System.out.print(i + ",");
    }
}
