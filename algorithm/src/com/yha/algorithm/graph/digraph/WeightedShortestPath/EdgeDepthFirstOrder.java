package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.queue.Queue;
import com.yha.algorithm.adt.stack.Stack;

/**
 * @author yha
 * @decription 使用加权有向边实现的有向图的深度优先顶点排序
 * @create 2017-10-28 19:23
 **/
public class EdgeDepthFirstOrder {

    private boolean[] marked;
    private Queue<Integer> pre; //所有顶点的前序排列
    private Queue<Integer> post; //所有顶点的后序排序
    private Stack<Integer> reversePost; //所有顶点的逆后序排列

    public EdgeDepthFirstOrder(EdgeWeightedDigraph G){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    /**
     * 深度优先搜索
     * @param G
     * @param v
     */
    private void dfs(EdgeWeightedDigraph G, int v){
        pre.enqueue(v);

        marked[v] = true;
        for (DirectedEdge e : G.adj(v))
            if (!marked[e.to()])
                dfs(G, e.to());

        post.enqueue(v);

        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }

}
