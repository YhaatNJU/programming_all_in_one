package com.yha.algorithm.graph.digraph;

import com.yha.algorithm.adt.stack.Stack;
import com.yha.algorithm.graph.Paths;

/**
 * @author yha
 * @decription 使用深度优先的有向图路径搜索类，可以解决有向图中两个顶点是否存在一条路径
 * @create 2017-10-22 10:33
 **/
public class DirectedDFP extends Paths{

    private boolean[] marked; //这个顶点上是否调用过dfs
    private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; //起点

    public DirectedDFP(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}
