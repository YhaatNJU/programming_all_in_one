package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.queue.Queue;
import com.yha.algorithm.adt.stack.Stack;

/**
 * @author yha
 * @decription 基于队列的Bellman-Ford算法，用来找到任意加权有向图的顶点s到其他顶点的最短路径，
 * 或者找到一个负权重和的环，找不到最短路径，
 * @create 2017-10-29 21:29
 **/
public class BellmanFordSP extends AbstractSP{

    private double[] distTo; //从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo; //从起点到某个顶点的最后一条边
    private boolean[] onQ; //该顶点是否存在于队列中
    private Queue<Integer> queue; //正在被放松的顶点
    private int cost; //relax()的调用次数
    private Iterable<DirectedEdge> cycle; //edgeTo[]中是否有负权重环

    public BellmanFordSP(EdgeWeightedDigraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        queue.enqueue(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !this.hasNegativeCycle()){
            int v= queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }


    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]){
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }

    private void findNegativeCycle(){
        int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);
        EdgeDirectedCycle cf = new EdgeDirectedCycle(spt);
        cycle = cf.cycle();

    }

    public boolean hasNegativeCycle(){
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    public static void main(String[] args){
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);

        //G.addEdge(new DirectedEdge(4, 5, .35));
        G.addEdge(new DirectedEdge(5, 4, -.66));
        G.addEdge(new DirectedEdge(4, 7, .37));
        G.addEdge(new DirectedEdge(5, 7, .28));
        G.addEdge(new DirectedEdge(7, 5, .28));
        G.addEdge(new DirectedEdge(5, 1, .32));
        G.addEdge(new DirectedEdge(0, 4, .38));
        //G.addEdge(new DirectedEdge(4, 0, .38));
        G.addEdge(new DirectedEdge(0, 2, .26));
        G.addEdge(new DirectedEdge(7, 3, .39));
        //G.addEdge(new DirectedEdge(3, 7, .39));
        G.addEdge(new DirectedEdge(1, 3, .29));
        G.addEdge(new DirectedEdge(2, 7, .34));
        //G.addEdge(new DirectedEdge(7, 2, .34));
        G.addEdge(new DirectedEdge(6, 2, .40));
        G.addEdge(new DirectedEdge(3, 6, .52));
        G.addEdge(new DirectedEdge(6, 0, .58));
        G.addEdge(new DirectedEdge(6, 4, .93));

        int s = 0;
        BellmanFordSP sp = new BellmanFordSP(G, s);
        if (sp.hasNegativeCycle()){
            System.out.println("There is a negative cycle in the digraph:");
            sp.cycle.forEach(System.out::print);
        }else {
            for (int v = 0; v < G.V(); v++){
                System.out.format("%d to %d (%.2f): ", s, v, sp.distTo(v));
                if (sp.hasPathTo(v)){
                    sp.pathTo(v).forEach(System.out::print);
                }
                System.out.println();
            }
        }
    }
}
