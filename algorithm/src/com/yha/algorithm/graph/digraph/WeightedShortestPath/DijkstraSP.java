package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.priorityQueue.IndexMiniPQ;
import com.yha.algorithm.adt.stack.Stack;

/**
 * @author yha
 * @decription 最短路径的Dijkstra算法
 * @create 2017-10-28 17:04
 **/
public class DijkstraSP extends AbstractSP{

    private DirectedEdge[] edgeTo; //最短路径中到顶点w（下标）的最后一条边
    private double[] distTo; //最短路径中到顶点w（下标）的边的权重
    private IndexMiniPQ<Double> pq; //用来保存被放松的顶点，顶点会按照权重大小被放松

    public DijkstraSP(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMiniPQ<>(G.V());
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;

        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
    }


    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }

    @Override
    public double distTo(int v) {
        return distTo[v];
    }
}
