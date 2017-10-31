package com.yha.algorithm.string;

import java.util.*;

/**
 * @author yha
 * @decription 字符串对应的字母表
 * @create 2017-10-30 20:00
 **/
public class Alphabet {

    private final char[] CHARS;
    private Map<Character, Integer> charPositionMap;

    public Alphabet(String s) {
        if (s == null || s.length() < 1)
            throw new IllegalArgumentException();

        charPositionMap = new HashMap<>(s.length());

        int position = 0;
        for (char c : s.toCharArray()){
            if (charPositionMap.containsKey(c))
                throw new IllegalArgumentException();
            charPositionMap.put(c, position++);
        }

        CHARS = s.toCharArray();
    }

    /**
     * 获取字母表中索引位置的字符
     * @param index
     * @return
     */
    public char toChar(int index){
        if (index < 0 || index >= CHARS.length)
            throw new IllegalArgumentException();
        return CHARS[index];
    }

    /**
     * 获取c的索引，在0到R-1之间
     * @param c
     * @return
     */
    public int toIndex(char c){
        Integer index = charPositionMap.get(c);
        if (index == null)
            return -1;
        return index;
    }

    /**
     * c是否在字母表中
     * @param c
     * @return
     */
    public boolean contains(char c){
        return charPositionMap.containsKey(c);
    }

    /**
     * 基数（字母表中的字符数量）
     * @return
     */
    public int R(){
        return CHARS.length;
    }

    /**
     * 表示一个索引所需的位数
     * @return
     */
    public int lgR(){
        int length = CHARS.length - 1;
        int r = 0;
        while (length > 0){
            length >>= 1;
            r++;
        }
        return r;
    }

    /**
     * 将s转换为R进制的整数
     * @param s
     * @return
     */
    public int[] toIndices(String s){
        if (s == null || s.length() < 1)
            throw new IllegalArgumentException();

        int[] indices = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (!contains(chars[i]))
                throw new IllegalArgumentException();

            indices[i] = toIndex(chars[i]);
        }
        return indices;
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     * @param indices
     * @return
     */
    public String toChars(int[] indices){
        if (indices == null || indices.length < 1)
            throw new IllegalArgumentException();
        char[] chars = new char[indices.length];
        for (int i = 0; i < chars.length; i++){
            int index = indices[i];
            if (index < 0 || index >= CHARS.length)
                throw new IllegalArgumentException();
            chars[i] = CHARS[index];
        }
        return String.valueOf(chars);
    }


    public static void main(String[] args){

        Alphabet alphabet = new Alphabet("abcdefghi");
        System.out.println(alphabet.contains('c'));
        System.out.println(alphabet.contains('h'));
        System.out.println(alphabet.lgR());
        System.out.println(alphabet.R());
        System.out.println(alphabet.toChar(3));
        //System.out.println(alphabet.toChar(-2));
        int[] indices = {0,1,1,3,3,5,1,5,1,4};
        System.out.println(alphabet.toChars(indices));
        System.out.println(alphabet.toIndex('b'));
        System.out.println(alphabet.toIndex('h'));
        for (int i : alphabet.toIndices("abcbcbdcd"))
            System.out.print(i);
        System.out.println();


    }

}
