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
        if (start == end)
            return a[start];
        int mid = start + (end-start)/2;
        if (a[start] <= a[mid] && a[start] <= a[end])
            return min(a, start, mid);
        else if (a[mid] <= a[start] && a[mid] <= a[end])
            return min(a, start, mid);
        else
            return min(a, mid, end);
    }

    public static void main(String[] args){
        int[] array = {6,1,2,3,4,5};
        CircleArrayMinElement min = new CircleArrayMinElement();
        System.out.println(min.minNumberInRotateArray(array));
    }
}
