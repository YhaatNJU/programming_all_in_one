package com.yha.algorithm.graph.depthFirst;

import com.yha.algorithm.graph.FixedVertexGraph;
import com.yha.algorithm.graph.Graph;
import com.yha.algorithm.graph.Search;

/**
 * @author yha
 * @decription 深度优先的图搜索方法
 * @create 2017-09-24 17:28
 **/
public class DepthFirstSearch extends Search {

    private boolean[] marked; //记录顶点是否已经访问
    private int count; //与顶点s连通的顶点数
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (int w : G.adj(v)){
            if (!marked[w])
                dfs(G, w);
        }
    }

    @Override
    public boolean marked(int w){
        return marked[w];
    }

    @Override
    public int count(){
        return count-1;
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

        Search search = new DepthFirstSearch(graph, 6);
        System.out.println(search.marked(8));
        System.out.println(search.count());
    }
}
