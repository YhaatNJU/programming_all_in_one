package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 排序类基类，包含排序用到的一些公用静态方法
 * @create 2017-09-19 22:48
 **/
public class Sort {


    /**
     * 比较一个元素是否小于另一个元素
     * @param a
     * @param b
     * @return
     */
    protected static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换两个元素
     * @param a
     * @param i
     * @param j
     */
    protected static void exchange(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 单行打印数组
     * @param a
     */
    public static void show(Comparable[] a){
        //在单行中打印数组
        for (int i = 0; i < a.length; i ++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    /**
     * 检查数组是否已排序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a){
        //测试数组是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;

        return true;
    }

}
