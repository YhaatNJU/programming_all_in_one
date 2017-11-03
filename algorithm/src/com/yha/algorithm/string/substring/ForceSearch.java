package com.yha.algorithm.string.substring;

/**
 * @author yha
 * @Description 暴力子字符串查找算法
 * @date 2017/11/3
 */
public class ForceSearch {

    public static int search(String pat, String txt){

        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++){
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            if (j == M)
                return i; //找到匹配
        }

        return N; //未找到匹配，默认返回文本长度N
    }

    public static void main(String[] args){
        String pat = "abc";
        String txt = "abacabdaeabababacabcadewda";
        int beginIndex = search(pat, txt);
        System.out.println(txt.substring(beginIndex, beginIndex + pat.length()));
    }
}
