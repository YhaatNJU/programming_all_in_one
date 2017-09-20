package com.yha.algorithm.sort;

/**
 * Author:yha
 * @description: 归并排序
 * Time:2017/9/20 下午7:44.
 * Illustration:
 */
public class MergeSort extends Sort {
    
    private static Comparable[] aux;  //归并所需的辅助数组
    
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
        
        //
    }
    
    /**
     * 原地归并排序
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(Comparable[] a, int low, int mid, int high) {
        //将a[low...mid]和a[mid+1...high]归并
        
        int i = low, j = mid + 1;
        
        for (int k = low; k <= high; k++)  //将a[low...high复制到aux[low...high]
            aux[k] = a[k];
        
        for (int k = low; k <= high; k++) { //归并a[low...high]
            if (i > mid)
                a[k] = aux[j++];
            else if (j > high)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j ++];
            else
                a[k] = aux[i++];
    
        }
    }
    
    /**
     * 自顶向下归并
     * @param a
     * @param low
     * @param high
     */
    private static void sort(Comparable[] a, int low, int high){
        //将数组a[low...high]排序
        if (high <= low)
            return;
        int mid = low + (high - low)/2;
        sort(a, low, mid); //将左半边排序
        sort(a, mid+1, high); //将右半边排序
        merge(a, low, mid, high); //归并结果
    }
    
    /**
     * 自底向上归并
     * @param a
     */
    public static void sort2(Comparable[] a){
        //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz) //sz表示子数组大小
            for (int low = 0; low < N-sz; low += sz+sz) //low表示子数组索引
                merge(a, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
        
        
    }
    
}
