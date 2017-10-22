package com.yha.algorithm.graph.digraph;

/**
 * @author www
 * @description 有向深度优先可达性搜索类
 *  可以用来解决有向图中单点可达性或者多点可达性问题
 * @create 2017-09-25 12:13
 **/

public class DirectedDFS {

    private boolean marked[];

    /**
     * 找出图G中s可达的所有顶点
     * @param G
     * @param s
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 找出sources顶点可以到达的所有顶点
     * 即多点可达性，典型应用是采用标记-清楚的垃圾回收器的可达性分析
     * @param G
     * @param sources
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s : sources)
            dfs(G, s);
    }

    /**
     * 深度优先搜索
     * @param G
     * @param v
     */
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w])
                dfs(G, w);
        }
    }

    /**
     * 判断从已知顶点（集）是否可达该顶点
     * @param v
     * @return
     */
    public boolean marked(int v){
        return marked[v];
    }



}
