package com.yha.algorithm.graph.digraph;

/**
 * @author yha
 * @decription 有向图的拓扑排序
 * @create 2017-10-22 13:26
 **/
public class Topological {

    private Iterable<Integer> order; //顶点的拓扑排序

    public Topological(Digraph G){
        DirectedCycle cycle = new DirectedCycle(G);
        if (!cycle.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
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
