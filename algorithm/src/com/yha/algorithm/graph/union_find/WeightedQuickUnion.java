package com.yha.algorithm.graph.union_find;

/**
 * @author yha
 * @decription 加权quick-union
 * quick-union的union操作盲目的将一个根触点链接到另一个根触点上，这样无法避免将大树链接到树上，导致链接后的树的高度急剧增大。
 * 加权quick-union使用一个数组来记录每个触点为根节点的树包含的触点数，
 * 然后union操作总是将触点树少的树链接到触点多的树上，以此来降低链接后树高度增长的速度
 * @create 2017-09-19 22:31
 **/
public class WeightedQuickUnion extends UnionFind{

    private int[] sz; //（由触点索引的）各个根节点所对应的分量的大小

    public WeightedQuickUnion(int N){
        super(N);
        sz = new int[N];
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    @Override
    public int find(int p) {
        //跟随链接找到根节点
        while (p != id[p])
            p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        //将小树的根节点链接到大树的根节点
        if (sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count --;
    }
}
