package com.yha.algorithm.graph.depthFirst;

import com.yha.algorithm.graph.CC;
import com.yha.algorithm.graph.FixedVertexGraph;
import com.yha.algorithm.graph.Graph;

/**
 * @author yha
 * @decription 采用深度优先算法的连通分量查找方法实现类
 * @create 2017-09-24 21:07
 **/
public class DepthFirstCC extends CC {

    private boolean[] marked; //顶点是否被访问
    private int[] id; //记录每个顶点所在的连通分量标识
    private int count; //连通分量数量

    public DepthFirstCC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++){
            if (!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if (!marked[w])
                dfs(G, w);
        }
    }

    @Override
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int id(int v) {
        return id[v];
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

        CC cc = new DepthFirstCC(graph);
        System.out.println(cc.count());
        System.out.println(cc.connected(1, 5));
        System.out.println(cc.connected(3, 7));
        System.out.println(cc.id(7));
    }
}
