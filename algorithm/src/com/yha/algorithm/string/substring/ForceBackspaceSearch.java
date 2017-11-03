package com.yha.algorithm.string.substring;

/**
 * @author yha
 * @Description 暴力子字符串算法的显式回退实现
 * @date 2017/11/3
 */
public class ForceBackspaceSearch {

    public static int search(String pat, String txt){

        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++){
            if (txt.charAt(i) == pat.charAt(j))
                j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == M)
            return i - M; //找到匹配
        else
            return N; //未找到匹配
    }

    public static void main(String[] args){
        String pat = "abc";
        String txt = "abacabdaeabababacabcadewda";
        int beginIndex = search(pat, txt);
        System.out.println(txt.substring(beginIndex, beginIndex + pat.length()));
    }
}
