package com.yha.question;

import java.util.ArrayList;

/**
 * @author yha
 * @Description 统计递增数组中和为s的所有序列
 * @date 2017/11/17
 */
public class FindContinuousSequenceOfSumS {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        int begin = 1;
        int end = 2;
        int tempSum = 1;
        boolean becomeShort = false;
        while (end <= (sum + 1) / 2){
            if (!becomeShort)
                tempSum += end;
            if (tempSum == sum){
                arrayLists.add(buildSequence(begin, end));
                tempSum -= begin;
                begin++;
                end++;
                becomeShort = false;
            }else if (tempSum < sum){
                end++;
                becomeShort = false;
            }else {
                tempSum -= begin;
                begin++;
                becomeShort = true;
            }
        }


        return arrayLists;
    }

    private ArrayList<Integer> buildSequence(int begin, int end){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = begin; i <= end; i++)
            integers.add(i);

        return integers;
    }

    public static void main(String[] args){

        FindContinuousSequenceOfSumS sumS = new FindContinuousSequenceOfSumS();
        for (ArrayList<Integer> arrayList : sumS.FindContinuousSequence(15)){
            for (Integer i : arrayList)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
