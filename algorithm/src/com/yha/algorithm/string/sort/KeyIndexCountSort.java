package com.yha.algorithm.string.sort;

/**
 * @author yha
 * @decription 键索引计数排序方法，是一种稳定的排序算法
 * @create 2017-10-30 21:55
 **/
public class KeyIndexCountSort {

    /**
     * 将根据StudentEntity的key()返回的数组将学生信息排序
     * @param a 学生信息数组，其中key()返回组号，从0开始，
     *          就等效于该组号在组号字幕表中的索引（从0开始）
     * @param R 字母表的元素数量
     */
    public static void sort(IIndex[] a, int R){

        int N = a.length;

        IIndex[] aux = new IIndex[N];//辅助数组
        int[] count = new int[R+1];

        //计算出现频率
        for (int i = 0; i < N; i++)
            count[a[i].key() + 1]++;

        //将频率转换为索引
        count[0] = 0;
        for (int r = 0; r < R; r++)
            count[r+1] += count[r];

        //将元素分类
        for (int i = 0; i < N; i++)
            aux[count[a[i].key()]++] = a[i];

        //回写
        for (int i = 0; i < N; i++)
            a[i] = aux[i];
    }

    public static void main(String[] args){
        StudentEntity a[] = {
                new StudentEntity(2,"Anderson"),
                new StudentEntity(3,"Brown"),
                new StudentEntity(3,"Davis"),
                new StudentEntity(4,"Garcia"),
                new StudentEntity(1,"Harris"),
                new StudentEntity(3,"Jackson"),
                new StudentEntity(4,"Johnson"),
                new StudentEntity(3,"Jones"),
                new StudentEntity(1,"Martin"),
                new StudentEntity(2,"Martinez"),
                new StudentEntity(2,"Miller"),
                new StudentEntity(1,"Moore"),
                new StudentEntity(2,"Robinson"),
                new StudentEntity(4,"Smith"),
                new StudentEntity(3,"Taylor"),
                new StudentEntity(4,"Thomas"),
                new StudentEntity(4,"Thompson"),
                new StudentEntity(2,"White"),
                new StudentEntity(3,"Williams"),
                new StudentEntity(4,"Wilson")

        };
        KeyIndexCountSort.sort(a, 5);
        for (StudentEntity s : a){
            System.out.println(s);
        }
    }

}
