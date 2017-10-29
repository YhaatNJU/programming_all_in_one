package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.stack.Stack;

/**
 * @author yha
 * @decription 使用加权有向边的有向图的环检测类
 * @create 2017-10-28 19:29
 **/
public class EdgeDirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; //有向环中的所有顶点（如果存在）
    private boolean[] onStack; //递归调用的栈上的所有顶点

    public EdgeDirectedCycle(EdgeWeightedDigraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    private void dfs(EdgeWeightedDigraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (this.hasCycle())
                return;
            else if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if (onStack[w]){
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

}
