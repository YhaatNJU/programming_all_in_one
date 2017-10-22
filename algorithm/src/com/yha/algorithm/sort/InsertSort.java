package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 插入排序
 * 默认第一个元素已经是有序的，这是必须的
 * 从第二个元素开始，在前面已经排序的序列中找到该元素可以插入的位置，使得插入后的序列仍然是有序的
 * 性能：
 *  最快：线性级别（已按照相同顺序排序）
 *  最慢：平方级别（已按照相反顺序排序）
 *  平均：
 *  特性：数组中的倒置元素的数量越少，性能越好
 * @create 2017-09-19 23:19
 **/
public class InsertSort extends Sort {

    public static void sort(Comparable[] a){
        //将a[]按照升序排列
        int N = a.length;
        for (int i = 1; i < N; i++){
            //将a[i]插入到a[i-1],a[i-2]...之中
//            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
//                exchange(a, j, j - 1);

            //更快的方法：在内循环中将较大的元素向右移动，而不总是交换两个元素，这样访问数组的次数就能减半
            int j = i;
            Comparable temp = a[i];
            for (; j > 0 && less(temp, a[j - 1]); j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

}
