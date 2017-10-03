package com.yha.example.thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Author:yha
 * Description:ForkJoinPool使用RecursiveTask示例
 * Time:2017/10/2 上午9:42.
 * Illustration:
 */
public class CountTask extends RecursiveTask<Long>{
    private static final int THRESHOLD = 1000;
    private long start;
    private long end;
    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for(long i = start; i <= end; i++){
                sum += i;
            }
        }else {
            //分成100个小任务
            long step = (end - start + 1) / 10;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 101; i++){
                long lastOne = pos + step - 1;
                if (pos > end)
                    break;
                if (lastOne > end)
                    lastOne = end;
                CountTask subTask = new CountTask(pos, lastOne);
                pos = lastOne + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for(CountTask t : subTasks){
                  sum += t.join();
            }
        }
        return sum;
    }
    public static void main(String[] args){
        
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(0, 20000000L);
        ForkJoinTask<Long> result = pool.submit(task);
        try {
            long res = result.get();
            System.out.println("sum = " + res);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
    
    
}
