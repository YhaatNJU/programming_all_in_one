package com.yha.algorithm.graph.union_find;

/**
 * @decription:
 * @author yha
 * @create
 */
public abstract class UnionFind {

    private int[] id; //分量ID（以触点作为索引）
    private int count; //分量数量

    public UnionFind(int N){
        //初始化分量ID数组
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }

    }

    /**
     * 返回连通分量数量
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * 查找触点p所在的连通分量
     * @param p
     * @return
     */
    public abstract int find(int p);

    /**
     * 判断两个触点是否相连，即判断两个触点是否在同一个连通分量中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 将两个（不相连的）分量连接起来
     * @param p
     * @param q
     */
    public abstract void union(int p, int q);


}
