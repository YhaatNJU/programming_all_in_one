package com.yha.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yha
 * @Description 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @date 2017/11/15
 */
public class RepeatedPermutation {
    public ArrayList<String> Permutation(String str) {
        if (str == null)
            return null;
        char[] chars = str.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        perm(chars, 0, strings);
        return strings;
    }


    private void perm(char[] chars, int index, ArrayList<String> stringArrayList){
        if (index == chars.length)
            return;
        if (index == chars.length - 1){
            String s = String.valueOf(chars);
            stringArrayList.add(s);
            return;
        }
        for (int i = index; i < chars.length; i++){
            if (i != index && chars[i] == chars[index])
                continue;
            exch(chars, i, index);
            perm(chars, index+1, stringArrayList);
            exch(chars, i, index);
        }
    }

    private void exch(char[] chars, int i, int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }


    public static void main(String[] args){
        String s = "CCD";
        RepeatedPermutation perm = new RepeatedPermutation();
        List<String> stringList = perm.Permutation(s);
        Collections.sort(stringList);
        if (stringList != null)
            stringList.forEach(System.out::println);
    }
}
