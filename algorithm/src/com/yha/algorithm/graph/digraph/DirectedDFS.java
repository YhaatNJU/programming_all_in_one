package com.yha.algorithm.graph.digraph;

import com.yha.algorithm.graph.Graph;

/**
 * @author www
 * @description 有向深度优先可达性搜索类
 * @create 2017-09-25 12:13
 **/

public class DirectedDFS {

    private boolean marked[];

    /**
     * 找出图G中s可达的所有顶点
     * @param G
     * @param s
     */
    public DirectedDFS(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 找出sources顶点可以到达的所有顶点
     * @param G
     * @param sources
     */
    public DirectedDFS(Graph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s : sources)
            dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w])
                dfs(G, w);
        }
    }

}
