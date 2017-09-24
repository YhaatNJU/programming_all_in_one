package com.yha.algorithm.graph.digraph;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;

/**
 * @author yha
 * @decription 固定顶点数的邻接表实现的有向图
 * @create 2017-09-24 23:23
 **/
public class FixedVertexDiGraph extends Digraph {

    private final int V;  //顶点个数
    private int E; //边的数目
    private Bag<Integer>[] adj; //邻接表

    public FixedVertexDiGraph(int vertices) {
        V = vertices;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; //创建邻接表
        for (int v = 0; v < V; v++) //将所有链表初始化为空
            adj[v] = new LinkedBag<>();
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public Digraph reverse() {
        Digraph D  = new FixedVertexDiGraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj[v])
                D.addEdge(w, v);
        return D;
    }
}
