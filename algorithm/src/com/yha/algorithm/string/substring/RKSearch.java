package com.yha.algorithm.string.substring;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author yha
 * @Description Rabin-Karp指纹字符串查找算法
 * @date 2017/11/3
 */
public class RKSearch {

    /**
     * 模式字符串（仅拉斯维加斯算法需要
     */
    private String pat;
    /**
     * 模式字符串的散列值
     */
    private long patHash;
    /**
     * 模式字符串的长度
     */
    private int M;
    /**
     * 一个很大的素数
     */
    private long Q;
    /**
     * 字母表的大小
     */
    private int R = 256;
    /**
     * R^(M-1) % Q
     */
    private long RM;

    public RKSearch(String pat){
        this.pat = pat;
        this.M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        for (int i = 1; i <= M-1; i++) //计算R^(M-1) % Q
            RM = (R * RM) % Q; //用于减去第一个数字时的计算

        patHash = hash(pat);

    }

    /**
     * 计算key[0..M-1]的散列值
     * @param key
     * @return
     */
    private long hash(String key){
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }

    private boolean check(String txt, int i){
        for (int j = 0; j < M; j++){
            if (txt.charAt(i+j) != pat.charAt(j))
                return false;
        }
        return true;
    }

    public int search(String txt){
        //在文本中查找相等的散列值
        int N = txt.length();
        long txtHash = hash(txt);
        if (patHash == txtHash && check(txt, 0))
            return 0; //一开始就匹配成功
        for (int i = M; i < N; i++){
            //减去第一个数字，加上最后一个数字，再次检查匹配
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (patHash == txtHash)
                if (check(txt, i - M + 1))
                    return i - M + 1; //找到匹配
        }

        return N; //未找到匹配
    }

    private static long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args){

        String pat = "abc";
        RKSearch search = new RKSearch(pat);
        String txt = "asdjlabeafjaladeaaabacabdabcadeawe";
        int beginIndex = search.search(txt);
        System.out.println("text:\t " + txt);
        System.out.print("pattern: ");
        for (int i = 0; i < beginIndex; i++)
            System.out.print(" ");
        System.out.println(txt.substring(beginIndex, beginIndex + pat.length()));
    }}
