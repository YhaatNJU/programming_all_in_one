package com.yha.algorithm.adt.symbolTable;


import com.yha.algorithm.adt.queue.Queue;

/**
 * @author yha
 * @decription 二叉查找树实现的符号表
 * @create 2017-09-22 20:54
 **/
public class BinarySearchTreeST<Key extends Comparable<Key>, Value>
        extends OrderedSymbolTable<Key, Value>{

    private Node root; //二叉查找树的根结点


    @Override
    public Key min() {
        if (root == null)
            return null;
        return min(root).key;
    }

    private Node min(Node x){
        if (x.left == null)
            return x;
        return min(x.left);
    }

    @Override
    public Key max() {
        if (root == null)
            return null;
        return max(root).key;
    }

    private Node max(Node x){
        if (x.right == null)
            return x;
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else
            return x;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        //返回以x为根结点的子树中小于x.key的键的数量
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(x.left, key);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(x.right, key);
        else
            return size(x.left);
    }

    @Override
    public Key select(int k) {
        if (root == null)
            return null;
        if (k > root.N){
            return null;
        }
        Node node = select(root, k);
        if (node == null)
            return null;
        return node.key;
    }

    private Node select(Node x, int k){
        //返回排名为k的结点
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k-t-1);
        else
            return x;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key low, Key high){
        if (x == null)
            return;
        int cmpLow = low.compareTo(x.key);
        int cmpHigh = high.compareTo(x.key);
        if (cmpLow < 0)
            keys(x.left, queue, low, high);
        if (cmpLow <= 0 && cmpHigh >= 0)
            queue.enqueue(x.key);
        if (cmpHigh > 0)
            keys(x.right, queue, low, high);

    }

    @Override
    public void put(Key key, Value val) {
        Node x = put(root, key, val);
        if (root == null)
            root = x;
    }

    private Node put(Node x, Key key, Value val){
        //如果key存在在于以x为根的子树中则更新它的值；
        //否则将以key和val为键值对的新结点插入到该子树中
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {

        return get(root, key);
    }

    private Value get(Node x, Key key){
        //在以x为根结点的子树中查找并返回可以所对应的值
        //如果找不到则返回null
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    @Override
    public void deleteMin() {
        if (root == null)
            return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
        if (root == null)
            return;
        root = deleteMax(root);
    }

    private Node deleteMax(Node x){
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null)
            return false;
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }


    private int size(Node x){
        if (x == null)
            return 0;
        else
            return x.N;
    }

    private class Node{
        private Key key; //键
        private Value val; //值
        private Node left, right; //指向左右子树的链接
        private int N; //以该结点为根的树中的结点总数

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }
}
