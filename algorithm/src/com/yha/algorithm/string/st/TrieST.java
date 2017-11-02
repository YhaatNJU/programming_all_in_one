package com.yha.algorithm.string.st;

import com.yha.algorithm.adt.queue.Queue;

import java.util.Arrays;

/**
 * @author yha
 * @decription 基于单词查找树的符号表
 * @create 2017-11-02 11:28
 **/
public class TrieST<Value> extends StringST<Value>{

    /**
     * 基数
     */
    private static int R = 256;

    /**
     * 单词查找树的根节点
     */
    private  Node root;

    /**
     * 单词
     */
    private int N;

    public TrieST(){
        root = new Node();
    }

    private static class Node{
        private Object val;
        private Node[] next = new Node[R];
    }

    @Override
    public void put(String key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("key不能为空");
        root = put(root, key, val, 0);
    }

    /**
     * 如果key存在于以x为根节点的子单词查找树中，则更新与它相关联的值
     * @param x
     * @param key
     * @param val
     * @param d
     * @return
     */
    private Node put(Node x, String key, Value val, int d){
        if (x == null)
            x = new Node();
        if (d == key.length()){
            if (x.val == null)
                if (val != null)
                    N++;
            else
                if (val == null)
                    N--;
            x.val = val;
            return x;
        }
        char c = key.charAt(d); //查找第d个字符所对应的子单词查找树
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    @Override
    public Value get(String key) {
        if (key == null)
            throw new IllegalArgumentException("key不能为空");
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return (Value) x.val;
    }

    /**
     * 返回以x为根节点的子单词查找树中与key相关联的值
     * @param x
     * @param key
     * @param d
     * @return
     */
    private Node get(Node x, String key, int d){
        if (x == null)
            return null;
        if (d == key.length())
            return x;
        char c = key.charAt(d); //找到第d个字符所对应的子单词查找树
        return get(x.next[c], key, d+1);
    }

    @Override
    public void delete(String key) {
        if (key == null)
            throw new IllegalArgumentException("key不能为空");
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d){
        if (x == null)
            return null;
        if (d == key.length()){
            x.val = null;
            N--;
        }else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        if (x.val != null)
            return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    @Override
    public boolean contains(String key) {
        if (key == null)
            return false;
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String longestPrefixOf(String s) {
        if (s == null)
            throw new IllegalArgumentException("s不能为空");
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    /**
     * 搜索和s匹配的最大键的长度
     * @param x
     * @param s
     * @param d
     * @param length
     * @return
     */
    private int search(Node x, String s, int d, int length){
        if (x == null)
            return length;
        if (x.val != null)
            length = d;
        if (d == s.length())
            return length;

        char c = s.charAt(d);
        return search(x.next[c], s, d+1, length);
    }

    @Override
    public Iterable<String> keysWithPrefix(String pre) {
        if (pre == null)
            throw new IllegalArgumentException("pre不能为空");
        Queue<String> q = new Queue<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    /**
     * 收集以x为根结点的子单词查找树中的有效结点（val != null）
     * @param x 当前子单词查找树的根结点
     * @param pre 到当前根结点的字符串
     * @param q 用来保存收集到的字符串
     */
    private void collect(Node x, String pre, Queue<String> q){
        if (x == null)
            return;
        if (x.val != null)
            q.enqueue(pre);
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }

    @Override
    public Iterable<String> keysThatMatch(String pat) {
        if (pat == null)
            throw new IllegalArgumentException("pat不能为空");
        Queue<String> q = new Queue<>();
        collect(root, "", pat, q);
        return q;
    }

    /**
     * 收集以x为根结点的子单词查找树中的有效结点（val != null）
     * @param x 当前子单词查找树的根结点
     * @param pre 到当前根结点的字符串
     * @param pat 用来匹配的字符串
     * @param q 用来保存收集到的字符串
     */
    private void collect(Node x, String pre, String pat, Queue<String> q){
        int d = pre.length();
        if (x == null)
            return;
        if (d == pat.length() && x.val != null)
            q.enqueue(pre);
        if (d == pat.length())
            return;
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++)
            if (next == '.' || next == c)
                collect(x.next[c], pre + c, pat, q);
    }

    @Override
    public int size() {
        //延时实现，应该尽量避免
        //return lazySize(root);
        return N;
    }



    /**
     * 单词查找树的延时实现，应该尽量避免
     * @param x
     * @return
     */
    private int lazySize(Node x){
        if ( x == null)
            return 0;
        int cnt = 0;
        if (x.val != null)
            cnt++;
        for (char c = 0; c < R; c++)
            cnt += lazySize(x.next[c]);

        return cnt;
    }

    @Override
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }


    public static void main(String[] args){
        String[] a = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "seashore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells"
        };

        StringST<Integer> st = new TrieST<>();
        int i = 5;
        Arrays.asList(a).forEach(s -> st.put(s, i));

        System.out.println(st.contains("seashore"));
        System.out.println(st.get("are"));
        System.out.println(st.isEmpty());
        System.out.println("keys:");
        st.keys().forEach(System.out::println);
        System.out.println("keysWithPrefix sea:");
        st.keysWithPrefix("sea").forEach(System.out::println);
        System.out.println("keysThatMatch seash.lls:");
        st.keysThatMatch("seash.lls").forEach(System.out::println);
        System.out.println("longestPrefixOf seashare:");
        System.out.println(st.longestPrefixOf("seasha"));
        System.out.println(st.size());
        st.delete("surelya");
        System.out.println(st.size());



    }

}
