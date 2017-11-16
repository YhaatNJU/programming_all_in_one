package com.yha.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yha
 * @Description 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符, 并返回它的位置
 * @date 2017/11/16
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.equals(""))
            return -1;
        char[] chars = str.toCharArray();
        int[] counts = new int[256];
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;
        for (char c : chars){
            counts[c]++;
        }

        Set<Character> occrOnce = new HashSet<>();
        for (int i = 0; i < counts.length; i++)
            if (counts[i] == 1)
                occrOnce.add((char)i);
        for (int i = 0; i < chars.length; i++){
            if (occrOnce.contains(chars[i]))
                return i;
        }

        return -1;
    }

    public static void main(String[] args){

        FirstNotRepeatingChar notRepeatingChar = new FirstNotRepeatingChar();
        System.out.println(notRepeatingChar.FirstNotRepeatingChar("google"));
    }
}
