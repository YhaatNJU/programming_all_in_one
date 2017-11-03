package com.yha.algorithm.string.st;

import com.yha.algorithm.adt.queue.Queue;

import java.util.Arrays;

/**
 * @author yha
 * @Description 基于三向单词查找树的符号表
 * @date 2017/11/2
 */
public class ThreeST<Value> extends StringST<Value> {

    /**
     * 树的根节点
     */
    private Node root;

    /**
     * 树的总结点树
     */
    private int N;

    public ThreeST() {
        root = new Node();
        N = 0;
    }

    private class Node{
        /**
         * 字符
         */
        char c;

        /**
         * 左三向单词查找树
         */
        Node left;

        /**
         * 中三向单词查找树
         */
        Node mid;

        /**
         * 右三向单词查找树
         */
        Node right;

        /**
         * 和字符串相关联的值
         */
        Value val;

    }

    @Override
    public void put(String key, Value val) {
        if (key == null || key.length() == 0)
            throw new IllegalArgumentException("key不能为null或长度为0");
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
        char c = key.charAt(d);
        if (x == null){
            x = new Node();
            x.c = c;
        }
        if (c < x.c)
            x.left = put(x.left, key, val, d);
        else if (c > x.c)
            x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)
            x.mid = put(x.mid, key, val, d+1);
        else{
            if (x.val == null)
                if (val != null)
                    N++;
            else
                if (val == null)
                    N--;
            x.val = val;
        }
        return x;
    }

    @Override
    public Value get(String key) {
        if (key == null || key.length() == 0)
            return null;
        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return x.val;
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
        char c = key.charAt(d);
        if (c < x.c)
            return get(x.left, key, d);
        else if ( c > x.c)
            return get(x.right, key, d);
        else if (d < key.length() - 1)
            return get(x.mid, key, d+1);
        else
            return x;
    }

    @Override
    public void delete(String key) {
        if (key == null || key.equals(""))
            return;
        root = delete(root, key, 0);
    }

    /**
     * 采用与二叉树类似的删除操作
     * @param x
     * @param key
     * @param d
     * @return
     */
    private Node delete(Node x, String key, int d){
        if (x == null)
            return null;
        char c = key.charAt(d);
        if (c < x.c)
            x.left = delete(x.left, key, d);
        else if (c > x.c)
            x.right = delete(x.right, key, d);
        else {
            if (d < key.length() - 1)
                x.mid = delete(x.mid, key, d+1);
            else {
                if (x.val != null){
                    Node t = x;
                    if (x.mid != null){
                        x = min(x.mid);
                        x.mid = deleteMin(x.mid);
                        x.left = t.left;
                        x.right = t.right;
                    }else if (x.right != null){
                        x = min(x.right);
                        x.right = deleteMin(x.right);
                        x.left = t.left;
                        x.mid = t.mid;
                    }else if (x.left != null){
                        x = min(x.left);
                        x.left = deleteMin(x.left);
                        x.mid = t.mid;
                        x.right = t.right;
                    }else {
                        x = null;
                    }
                    N--;
                }

            }
        }

        return x;
    }

    /**
     * 返回以x为根结点的子树的最小结点
     * @param x
     * @return
     */
    private Node min(Node x){
        if (x.left == null){
            if (x.mid == null)
                return x;
            else
                return min(x.mid);
        }
        return min(x.left);

    }

    /**
     * 删除以x为根结点的子树的最小结点
     * @param x
     * @return
     */
    private Node deleteMin(Node x){
        if (x.left == null){
            if (x.mid == null)
                return x.right;
            else
                return deleteMin(x.mid);
        }
        return deleteMin(x.left);
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.equals(""))
            return false;
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public String longestPrefixOf(String s) {
        if (s == null)
            throw new IllegalArgumentException("s不能为空");
        if (s.length() == 0)
            return null;
        int length = search(root, s, 0, 0);
        return s.substring(0, length + 1);
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
        if (c < x.c)
            return search(x.left, s, d, length);
        else if (c > x.c)
            return search(x.right, s, d, length);
        else
            return search(x.mid, s, d+1, length);
    }

    @Override
    public Iterable<String> keysWithPrefix(String pre) {
        if (pre == null)
            throw  new IllegalArgumentException("pre不能为空");
        Queue<String> q = new Queue<>();
        Node x = get(root, pre, 0);
        if (x == null)
            return q;
        if (x.val != null)
            q.enqueue(pre);
        collect(x.mid, new StringBuilder(pre), q);
        return q;
    }

    /**
     * 收集以x为根结点的子单词查找树中的有效结点（val != null）
     * @param x 当前子单词查找树的根结点
     * @param prefix 到当前根结点之前的字符串
     * @param q 用来保存收集到的字符串
     */
    private void collect(Node x, StringBuilder prefix, Queue<String> q){
        if (x == null)
            return;
        collect(x.left, prefix, q);
        if (x.val != null)
            q.enqueue(prefix.toString() + x.c);
        collect(x.mid, prefix.append(x.c), q);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, q);
    }

    @Override
    public Iterable<String> keysThatMatch(String pat) {
        if (pat == null)
            throw new IllegalArgumentException("匹配字符串pat不能为null");
        Queue<String> q = new Queue<>();
        collect(root, new StringBuilder(), 0, pat, q);
        return q;
    }

    /**
     * 收集以x为根结点的子单词查找树中的有效结点（val != null）
     * @param x 当前子单词查找树的根结点
     * @param prefix 到当前根结点之前的字符串
     * @param d 当前结点在形成字符串的长度
     * @param pat 用来匹配的字符串
     * @param q 用来保存收集到的字符串
     */
    private void collect(Node x, StringBuilder prefix, int d, String pat, Queue<String> q){
        if (x == null)
            return;
        char c = pat.charAt(d);
        if (c == '.' || c < x.c)
            collect(x.left, prefix, d, pat, q);
        if (c == '.' || c == x.c){
            if (d == pat.length() - 1 && x.val != null)
                q.enqueue(prefix.toString() + x.c);
            if (d < pat.length() - 1){
                collect(x.mid,prefix.append(x.c), d+1, pat, q);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c)
            collect(x.right, prefix, d, pat, q);
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> q = new Queue<>();
        collect(root, new StringBuilder(), q);
        return q;
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

        StringST<Integer> st = new ThreeST<>();
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
        st.delete("surely");
        System.out.println(st.size());
        System.out.println(st.contains("surely"));
        st.delete("seashells");
        System.out.println(st.size());
        System.out.println(st.contains("seashells"));
    }
}
