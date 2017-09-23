package com.yha.algorithm.adt.symbolTable;


import com.yha.algorithm.adt.queue.Queue;

import java.util.NoSuchElementException;

/**
 * @author yha
 * @decription 红黑树实现的2-3树的符号表
 * 正常红红黑树的特点：
 *  所有空链接到根结点的黑链接树相等
 *  所有红链接都是左链接
 *
 * 操作红黑树的特点：
 *  新增结点都是红色的
 *  如果结点的左子结点是红色的，且左子结点的左子结点也是红色的，则需要右旋(rotateRight)
 *  如果结点的右子结点是红色的，则需要左旋(rotateLeft)
 *  如果结点的左右子结点都是红色的，则需要变换颜色(flipColors)
 *  添加结点后需要把指向根结点的链接变成黑色
 * @create 2017-09-23 10:05
 **/
public class RedBlackTreeST<Key extends Comparable<Key>, Value>
        extends OrderedSymbolTable<Key, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;


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
        if (low == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (high == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, low, high);
        return queue;
    }

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null)
            return;
        if (val == null)
            delete(key);

        //查找key，找到则更新其值，否则为它新建一个结点
        root = put(root, key, val);
        root.color = BLACK;

    }

    private Node put(Node h, Key key, Value val){
        if (h == null) //标准的插入操作，和父结点用红色链接相连
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0)
            h.left = put(h.left, key ,val);
        else if (cmp > 0)
            h.right = put(h.right, key, val);
        else
            h.val = val;

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    public Value get(Key key) {
        if (key == null)
            return null;
        return get(root, key);
    }

    private Value get(Node x, Key key){
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
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    private Node delete(Node h, Key key){
        // assert get(h, key) != null;

        if (key.compareTo(h.key) < 0)  {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            }else
                h.right = delete(h.right, key);
        }
        return balance(h);
    }

    @Override
    public void deleteMin() {
        if (isEmpty())
            return;
        if (!isRed(root.left) && isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty())
            root.color = BLACK;
    }

    private Node deleteMin(Node h){
        if (h.left == null)
            return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }


    private Node moveRedLeft(Node h){
        //假设结点h为红色，h.left和h.left.left都是黑色
        //将h.left或者h.left的子结点之一有变红
        flipColors(h);
        if (isRed(h.right.left)){
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node balance(Node h){
        if (isRed(h.right))
            h = rotateLeft(h);
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }



    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
        // assert check();
    }

    private Node deleteMax(Node h){
        if (isRed(h.left))
            h = rotateRight(h);

        if (h.right == null)
            return null;

        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);

        h.right = deleteMax(h.right);

        return balance(h);
    }

    private Node moveRedRight(Node h){
        //假设结点h为红色，h.right和h.right.left都是黑色
        //将h.right或者h.right的子结点之一变红
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }


    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    /**
     * 返回以x为根结点的子树的结点总数
     * @param x
     * @return
     */
    private int size(Node x){
        if (x == null)
            return 0;
        return x.N;
    }

    private class Node{
        private Key key;  //键
        private Value val; //相关联的值
        private Node left, right; //左右子树
        int N; // 这棵子树中的结点总数
        boolean color; //由其父结点指向它的链接的颜色

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }

    /**
     * 判断指向该结点的链接的颜色是否为红色
     * @param x
     * @return
     */
    private boolean isRed(Node x){
        if (x == null)
            return false;
        return x.color == RED;
    }

    /**
     * 左旋
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 当一个结点的左右子结点的链接都是红色的时候，需要将左右子结点的链接
     * 都变成黑色，
     * 同时将自己的链接变成红色
     * @param h
     * h must have opposite color of its two children
     * assert (h != null) && (h.left != null) && (h.right != null);
     * assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
     *  || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
     */
    private void flipColors(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }
}
