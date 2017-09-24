package com.yha.algorithm.graph.depthFirst;

import com.yha.algorithm.graph.FixedVertexGraph;
import com.yha.algorithm.graph.Graph;

/**
 * @author yha
 * @decription 采用深度优先算法判断图是否有环
 * @create 2017-09-24 21:26
 **/
public class DepthFirstCycle {

    private boolean[] marked; //该顶点是否被访问过
    private boolean hasCycle; //是否有环

    public DepthFirstCycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++){
            if (!marked[s])
                dfs(G, s, s);
        }
    }

    private void dfs(Graph G, int v, int u){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u)
                hasCycle = true;
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args){
        Graph graph = new FixedVertexGraph(9);
        graph.addEdge(0, 1);
        //graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        //graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        //graph.addEdge(5, 6);
        graph.addEdge(7 ,8);

        DepthFirstCycle cycle = new DepthFirstCycle(graph);
        System.out.println(cycle.hasCycle);
    }
}
