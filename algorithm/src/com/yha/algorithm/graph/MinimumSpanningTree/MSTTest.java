package com.yha.algorithm.graph.MinimumSpanningTree;

/**
 * @author yha
 * @decription 最小生成树测试类
 * @create 2017-10-22 21:24
 **/
public class MSTTest {

    public static void main(String[] args){

        EdgeWeightGraph G = new EdgeWeightGraph(8);
        G.addEdge(new Edge(4, 5, .35));
        G.addEdge(new Edge(4, 7, .37));
        G.addEdge(new Edge(5, 7, .28));
        G.addEdge(new Edge(0, 7, .16));
        G.addEdge(new Edge(1, 5, .32));
        G.addEdge(new Edge(0, 4, .38));
        G.addEdge(new Edge(2, 3, .17));
        G.addEdge(new Edge(1 , 7, .19));
        G.addEdge(new Edge(0, 2, .26));
        G.addEdge(new Edge(1, 2, .36));
        G.addEdge(new Edge(1, 3, .29));
        G.addEdge(new Edge(2, 7, .34));
        G.addEdge(new Edge(6, 2, .40));
        G.addEdge(new Edge(3, 6, .52));
        G.addEdge(new Edge(6, 0, .58));
        G.addEdge(new Edge(6, 4, .93));

        LazyPrimMST mst = new LazyPrimMST(G);
        mst.edges().forEach(e -> {
            int v = e.either();
            int w = e.other(v);
            System.out.format("%d-%d ", v, w);
        });
        System.out.println();
        System.out.println(mst.weight());
    }

}
