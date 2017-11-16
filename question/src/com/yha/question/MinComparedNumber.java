package com.yha.question;

import java.util.*;

/**
 * @author yha
 * @Description 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @date 2017/11/16
 */
public class MinComparedNumber {
    public String PrintMinNumber(int [] numbers) {

        if (numbers == null)
            return null;
        if (numbers.length == 0)
            return "";

        List<Integer> list = new ArrayList<>(numbers.length);
        for (int i : numbers)
            list.add(i);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });


        String result = "";
        for (int i : list){
            result += i;
        }

        return result;
    }


    public static void main(String[] args){

        MinComparedNumber number = new MinComparedNumber();
        int[] numbers = {3, 32, 321};
        System.out.println(number.PrintMinNumber(numbers));

    }
}
