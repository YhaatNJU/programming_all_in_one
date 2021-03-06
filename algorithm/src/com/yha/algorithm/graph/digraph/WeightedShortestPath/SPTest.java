package com.yha.algorithm.graph.digraph.WeightedShortestPath;

/**
 * @author yha
 * @decription 最短路径测试类
 * @create 2017-10-28 16:51
 **/
public class SPTest {

    public static void main(String[] args){
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);

        //为测试无环有向图注释掉或添加了一些边

        //G.addEdge(new DirectedEdge(4, 5, .35));
        G.addEdge(new DirectedEdge(5, 4, .35));
        G.addEdge(new DirectedEdge(4, 7, .37));
        G.addEdge(new DirectedEdge(5, 7, .28));
        //G.addEdge(new DirectedEdge(7, 5, .28));
        G.addEdge(new DirectedEdge(5, 1, .32));

        //G.addEdge(new DirectedEdge(0, 4, .38));
        G.addEdge(new DirectedEdge(4, 0, .38));

        G.addEdge(new DirectedEdge(0, 2, .26));

        //G.addEdge(new DirectedEdge(7, 3, .39));
        G.addEdge(new DirectedEdge(3, 7, .39));

        G.addEdge(new DirectedEdge(1, 3, .29));

        //G.addEdge(new DirectedEdge(2, 7, .34));
        G.addEdge(new DirectedEdge(7, 2, .34));

        G.addEdge(new DirectedEdge(6, 2, .40));
        G.addEdge(new DirectedEdge(3, 6, .52));
        G.addEdge(new DirectedEdge(6, 0, .58));
        G.addEdge(new DirectedEdge(6, 4, .93));

//        AbstractSP sp = new AcyclicSP(G, 0);
//        if (sp.hasPathTo(6)){
//            System.out.println(sp.distTo(6));
//            sp.pathTo(6).forEach(System.out::println);
//        }

        int start = 5;
        AbstractSP sp = new AcyclicLongestPath(G, start);
        for (int v = 0; v < G.V(); v++){
            System.out.format("%d to %d (%.2f): ", start, v, sp.distTo(v));
            if (sp.hasPathTo(v)){
                sp.pathTo(v).forEach(System.out::print);
            }
            System.out.println();
        }
    }

}
