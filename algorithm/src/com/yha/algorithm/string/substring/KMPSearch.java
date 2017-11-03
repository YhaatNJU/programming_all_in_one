package com.yha.algorithm.string.substring;

/**
 * @author yha
 * @Description KMP子字符串搜索算法
 * @date 2017/11/3
 */
public class KMPSearch {

    private int M;
    private int R = 256;
    private int[][] dfa;
    private String pat;

    public KMPSearch(String pat){
        if (pat == null || pat.length() == 0)
            throw new IllegalArgumentException("pat不能为空");
        this.pat = pat;
        M = pat.length();
        dfa = new int[R][M];
        buildDFA();
    }

    private void buildDFA(){
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++){
            //计算dfa[][j]
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X]; //复制匹配失败情况下的值
            dfa[pat.charAt(j)][j] = j+1; //设置匹配成功情况下的值
            X = dfa[pat.charAt(j)][X]; //更新重启状态
        }
    }

    public int search(String txt){
        //模拟DFA处理文本txt的操作
        int i, j, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M)
            return i - M; //找到匹配
        else
            return N; //未找到匹配
    }

    public static void main(String[] args){

        String pat = "abc";
        KMPSearch search = new KMPSearch(pat);
        String txt = "asdjlabeafjaladeaaabacabdabcadeawe";
        int beginIndex = search.search(txt);
        System.out.println("text:\t " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < beginIndex; i++)
            System.out.print(" ");
        System.out.println(txt.substring(beginIndex, beginIndex + pat.length()));
    }
}
