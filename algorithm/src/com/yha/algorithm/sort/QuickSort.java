package com.yha.algorithm.sort;

/**
 * Author:yha
 * @description: 快速排序
 * Time:2017/9/20 下午9:05.
 * Illustration:
 */
public class QuickSort extends Sort{
    
    public static void sort(Comparable[] a){
        
        //可以提前打乱数组，消除对输入的依赖
        
        
        sort(a, 0, a.length - 1);
    }
    
    
    
    private static void sort(Comparable[] a, int low, int high){
        if (high <= low)
            return;
        int j = partition(a, low, high); //切分数组
        sort(a, low, j-1); //将左半边排序
        sort(a, j+1, high); //将右半边排序
    }
    
    
    /**
     * 将数组切分并返回切分点
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(Comparable[] a, int low, int high){
        //将数组分为a[low...i-1], a[i], a[i+1...high]
        int i = low, j = high + 1; //左右扫描指针
        Comparable v = a[low]; //切分元素
        while (true){
            //左右扫描， 检查扫描是否结束并交换元素
            while (less(a[++i], v))
                if (i == high)
                    break;
            while (less(v, a[--j]))
                if (j == low)
                    break;
            if (i >= j)
                break;
            exchange(a, i, j);
        }
        
        exchange(a, low, j); //将v放入正确的位置
        return j;
    }
}
