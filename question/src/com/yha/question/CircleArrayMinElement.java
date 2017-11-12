package com.yha.question;

/**
 * @author yha
 * @decription 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @create 2017-11-11 23:06
 **/
public class CircleArrayMinElement {
    public int minNumberInRotateArray(int [] array) {
        if (array == null)
            return -1;
        if (array.length == 0)
            return 0;
        return min(array, 0, array.length - 1);
    }


    private int min(int[] a, int start, int end){
        if (end - start <= 1){
            if (a[start] < a[end])
                return a[start];
            else
                return a[end];
        }
        int mid = start + (end-start)/2;
        if (a[start] <= a[mid] && a[start] < a[end])
            return a[start];
        else if (a[end] <= a[start] && a[end] <= a[mid])
            return min(a, mid, end);
        else {
            return min(a, start, mid);
        }

    }

    public static void main(String[] args){
        int[] array = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
        CircleArrayMinElement min = new CircleArrayMinElement();
        System.out.println(min.minNumberInRotateArray(array));
    }
}
