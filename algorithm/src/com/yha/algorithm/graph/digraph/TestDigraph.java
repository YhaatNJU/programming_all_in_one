package com.yha.algorithm.graph.digraph;

/**
 * @author yha
 * @decription 测试有向图类
 * @create 2017-10-22 10:38
 **/
public class TestDigraph {

    public static void main(String[] args){

        Digraph G = new FixedVertexDiGraph(13);
        G.addEdge(0,1);
        G.addEdge(0,5);

        G.addEdge(0,6);

        G.addEdge(2,0);
        G.addEdge(2,3);
        //G.addEdge(3,2);
        G.addEdge(3,5);
        //G.addEdge(4,2);
        //G.addEdge(4,3);
        G.addEdge(5,4);
        //G.addEdge(6,0);
        G.addEdge(6,4);
        G.addEdge(6,9);
        G.addEdge(7,6);
        //G.addEdge(7,8);
        G.addEdge(8,7);
        //G.addEdge(8,9);
        G.addEdge(9,10);
        G.addEdge(9,11);

        G.addEdge(9,12);

        //G.addEdge(10,12);
        //G.addEdge(11,4);
        G.addEdge(11,12);
        //G.addEdge(12,9);

        //测试可达性
        /*Bag<Integer> sources = new LinkedBag<>();
        sources.add(1);
        sources.add(2);
        sources.add(6);

        DirectedDFS dfs = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); v++)
            if (dfs.marked(v))
                System.out.print(v + " ");
        System.out.println();*/

        //测试深度优先路径搜索
        /*Paths paths = new DirectedDFP(G, 2);
        for (int v = 0; v < G.V(); v++){
            if (paths.hasPathTo(v)){
                paths.pathTo(v).forEach((i)->{
                    System.out.print(i + " ");
                });
                System.out.println();
            }
        }*/

        //测试广度优先的最短路径搜索
        /*Paths paths = new DirectedBFP(G,6);
        for (int v = 0; v < G.V(); v++) {
            if (paths.hasPathTo(v)) {
                paths.pathTo(v).forEach((i) -> {
                    System.out.print(i + " ");
                });
                System.out.println();
            }
        }*/

        //测试有向图是否有环
        /*DirectedCycle cycle = new DirectedCycle(G);
        if (cycle.hasCycle()){
            cycle.cycle().forEach((i) -> System.out.print(i + " "));
        }*/

        //测试顶点排序
        DepthFirstOrder order = new DepthFirstOrder(G);
        order.pre().forEach(i -> System.out.print(i + " "));
        System.out.println();
        order.post().forEach(i -> System.out.print(i + " "));
        System.out.println();
        order.reversePost().forEach(i -> System.out.print(i + " "));
        System.out.println();

        //测试拓扑排序
        Topological topological = new Topological(G);
        if (topological.isDAG()){
            topological.order().forEach(i -> System.out.print(i + " "));
        }else {
            System.out.println("The Digraph is not a DAG.");
        }

    }

}
