package com.yha.algorithm.graph.digraph.WeightedShortestPath;

/**
 * @author yha
 * @decription 使用加权有向边实现的有向图的拓扑排序
 * @create 2017-10-28 19:27
 **/
public class EdgeTopological {

    private Iterable<Integer> order; //顶点的拓扑排序

    public EdgeTopological(EdgeWeightedDigraph G){
        EdgeDirectedCycle cycle = new EdgeDirectedCycle(G);
        if (!cycle.hasCycle()){
            EdgeDepthFirstOrder dfs = new EdgeDepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }

}
