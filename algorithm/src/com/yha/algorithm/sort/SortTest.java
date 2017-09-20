package com.yha.algorithm.sort;

/**
 * @author yha
 * @decription 排序类测试类
 * @create 2017-09-19 23:13
 **/
public class SortTest {

    public static void main(String[] args){

        Integer[] a = {1, 5, 12, 4, 17, 19, 21, 2, 6, 7, 32, 28, 41, 45, 16, 12, 17};

        //SelectSort.sort(a);

        //InsertSort.sort(a);
        
        //MergeSort.sort2(a);

        //ShellSort.sort(a);
        
        QuickSort.sort(a);


        Sort.show(a);


    }

}
