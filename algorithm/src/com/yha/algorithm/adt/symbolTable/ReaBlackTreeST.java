package com.yha.algorithm.adt.symbolTable;


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
public class ReaBlackTreeST<Key extends Comparable<Key>, Value>
        extends OrderedSymbolTable<Key, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;


    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return null;
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
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
     */
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
