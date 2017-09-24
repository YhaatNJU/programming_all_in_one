package com.yha.algorithm.graph.depthFirst;

import com.yha.algorithm.graph.FixedVertexGraph;
import com.yha.algorithm.graph.Graph;

/**
 * @author yha
 * @decription 判断一个图是否能图成两种颜色，使得一条边的两个顶点颜色不相同（二分图）
 * @create 2017-09-24 21:44
 **/
public class DepthFirstTwoColor {

    private boolean[] marked; //顶点是否被访问过
    private boolean[] color; //顶点颜色
    private boolean isTwoColorable = true; //是否可以被二分

    public DepthFirstTwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++){
            if (!marked[s])
                dfs(G, s);

        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)){
            if (!marked[w]){
                color[w] = !color[v];
                dfs(G, w);
            }else if (color[w] == color[v])
                isTwoColorable = false;
        }
    }

    public boolean isTwoColorable(){
        return isTwoColorable;
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

        DepthFirstTwoColor twoColor = new DepthFirstTwoColor(graph);
        System.out.println(twoColor.isTwoColorable());
    }

}
