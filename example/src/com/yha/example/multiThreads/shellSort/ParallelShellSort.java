package com.yha.example.multiThreads.shellSort;

import com.yha.util.file.ArrayFileUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yha
 * @decription 使用并行方式的希尔排序
 * @create 2017-10-06 21:57
 **/
public class ParallelShellSort {

    private static int[] arr; //方便线程读取的数组
    private static CountDownLatch latch;

    public static class ShellSortTask implements Runnable{

        int h = 0;
        int start;

        public ShellSortTask(int start, int h) {
            this.start = start;
            this.h = h;
        }

        @Override
        public void run() {
            for (int j = start; j < arr.length; j += h){
                int temp = arr[j];
                int k = j;
                for (; k >= h && temp < arr[k-h]; k -= h){
                    arr[k] = arr[k-h];
                }
                arr[k] = temp;
            }
            latch.countDown();
            System.out.println("latch: " + latch.getCount());
        }
    }

    public static void pShellSort(int[] data) throws InterruptedException{
        ExecutorService pool = null;
        int h = 1;
        while (h < data.length/3)
            h = h*3 + 1;
        arr = data;
        while (h >= 1){
            System.out.println("h = " + h);

            if (h <= 4 || h >= 20){
                for (int i = h; i < 2 * h && i < arr.length; i++){
                    for (int j = h; j < arr.length; j += h){
                        int temp = arr[j];
                        int k = j;
                        for (; k >= h && temp < arr[k]; k -= h){
                            arr[k] = arr[k-h];
                        }
                        arr[k] = temp;
                    }
                }
            }else {
                latch = new CountDownLatch(h);
                pool = Executors.newFixedThreadPool(h);
                for (int i = h; i < 2 * h && i < arr.length; i++){
                    pool.execute(new ShellSortTask(i, h));
                }
                latch.await();
                pool.shutdown();
            }

            h = h/3;
        }
        pool.shutdown();
        data = arr;
    }

    public static void main(String[] args) throws InterruptedException{

        int[] data = new int[50000000];
        ArrayFileUtil.readIntArray(data, "file/numbers/numbers.txt");
        long start = System.currentTimeMillis();
        pShellSort(data);
        long end = System.currentTimeMillis();
        System.out.println("Take time: " + (end - start) / 1000 + "seconds");
        ArrayFileUtil.writeIntArray(data, "file/numbers/numbers_sorted.txt", false);
    }

}
