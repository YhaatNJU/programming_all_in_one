package com.yha.example.multiThreads.oddEvenSort;

import com.yha.util.file.ArrayFileUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:yha
 * Description:使用多线程实现的奇偶交互排序
 * Time:2017/10/6 下午3:21.
 * Illustration:
 */
public class ParallerOddEvenSort {

    static int exchFlag = 1;
    
    static int[] arr;
    
    static synchronized int getExchFlag(){
        return exchFlag;
    }
    
    static synchronized void setExchFlag(int flag){
        exchFlag = flag;
    }
    
    public static class OddEvenSortTask implements Runnable{
        int start;
        int end;
        CountDownLatch latch;
    
        public OddEvenSortTask(int start, int end, CountDownLatch latch) {
            this.start = start;
            this.end = end;
            this.latch = latch;
        }
    
        @Override
        public void run() {
             boolean isExch = false;
            for (int i = start; i < end; i += 2){
                if (arr[i] > arr[i +1]){
                    int temp = arr[i];
                    arr[i] = arr[i +1];
                    arr[i +1] = temp;
                    isExch = true;
                }
            }
            if (isExch){
                setExchFlag(1);
            }
            latch.countDown();
        }
    }
    
    public static void pOddEvenSort(int[] data) throws InterruptedException{
        
        arr = data;
        ExecutorService pool = Executors.newCachedThreadPool();
        int start = 0;
        while (getExchFlag() == 1 || start == 1){
            
            CountDownLatch latch = new CountDownLatch(8);
            int n = data.length / 7;
            int i = start;
            int j = 0;
            boolean isEnd = false;
            for (;i < data.length && j < 7; i += n, j++){
                int end = i + n - 1;
                if (end >= data.length){
                    end = data.length - 1;
                    isEnd = true;
                    break;
                }
                pool.submit(new OddEvenSortTask(i, end, latch));
            }
            if (isEnd){
                pool.submit(new OddEvenSortTask(data.length - 1, data.length - 1, latch));
            }else {
                pool.submit(new OddEvenSortTask(i, data.length - 1, latch));
            }
            
            latch.await();
            if (start == 0)
                start = 1;
            else
                start = 0;
        }
        
        data = arr;
    }
    
    public static void main(String[] args) throws InterruptedException{
        int[] data = new int[100000];
        ArrayFileUtil.readIntArray(data, "file/numbers/numbers.txt");
        long start = System.currentTimeMillis();
        pOddEvenSort(data);
        long end = System.currentTimeMillis();
        System.out.println("Take time: " + (end - start) / 1000 + "seconds");
        ArrayFileUtil.writeIntArray(data, "file/numbers/numbers_sorted.txt", false);
    }
    
}
