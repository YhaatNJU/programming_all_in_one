package com.yha.algorithm.string.substring;

/**
 * @author yha
 * @Description Boyer-Moore字符串匹配算法（启发式德处理不匹配的字符）
 * @date 2017/11/3
 */
public class BMSearch {

    /**
     * 记录不匹配字符需要向前跳跃多少位置
     */
    private int[] right;

    private int R = 256;
    private String pat;

    private int M;


    public BMSearch(String pat){
        if (pat == null)
            throw new IllegalArgumentException("pat不能为null");
        this.pat = pat;
        M = pat.length();
        right = new int[R];
        buildJumpTable();
    }

    private void buildJumpTable(){
        for (int c = 0; c < R; c++)
            right[c] = -1; //不包含在模式字符串中字符的值为-1
        for (int j = 0; j < M; j++){
            right[pat.charAt(j)] = j;
        }
    }

    /**
     * 在txt中操作模式字符串
     * @param txt
     * @return
     */
    public int search(String txt){
        int N = txt.length();
        int skip;
        for (int i = 0; i <= N-M; i += skip){
            //模式字符串和文本在位置i匹配吗?
            skip = 0;
            for (int j = M-1; j >= 0; j--){
                if (pat.charAt(j) != txt.charAt(i+j)){
                    skip = j - right[txt.charAt(i+j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            }
            if (skip == 0)
                return i; //找到匹配
        }

        return N; //未找到匹配
    }

    public static void main(String[] args){

        String pat = "abc";
        BMSearch search = new BMSearch(pat);
        String txt = "asdjlabeafjaladeaaabacabdabcadeawe";
        int beginIndex = search.search(txt);
        System.out.println("text:\t " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < beginIndex; i++)
            System.out.print(" ");
        System.out.println(txt.substring(beginIndex, beginIndex + pat.length()));
    }
}
