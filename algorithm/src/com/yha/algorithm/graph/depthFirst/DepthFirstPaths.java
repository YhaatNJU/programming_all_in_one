package com.yha.algorithm.graph.depthFirst;

import com.yha.algorithm.adt.stack.Stack;
import com.yha.algorithm.graph.FixedVertexGraph;
import com.yha.algorithm.graph.Graph;
import com.yha.algorithm.graph.Paths;

/**
 * @author yha
 * @decription 采用深度优先的图路径搜索类
 * @create 2017-09-24 19:23
 **/
public class DepthFirstPaths extends Paths {

    private boolean[] marked; //这个顶点上是否调用过dfs
    private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; //起点

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
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

    public static void main(String[] args){

        Graph graph = new FixedVertexGraph(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7 ,8);

        Paths paths = new DepthFirstPaths(graph, 0);
        System.out.println(paths.hasPathTo(6));
        System.out.println(paths.hasPathTo(8));
        for (int i : paths.pathTo(6))
            System.out.println(i + " ");

    }
}
