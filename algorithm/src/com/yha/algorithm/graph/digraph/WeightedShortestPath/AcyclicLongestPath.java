package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.stack.Stack;

/**
 * @author yha
 * @decription 加权无环有向图的最长路径算法，可以允许边为负值
 * @create 2017-10-28 20:15
 **/
public class AcyclicLongestPath extends AbstractSP{

    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicLongestPath(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.NEGATIVE_INFINITY;

        distTo[s] = 0;

        EdgeTopological top = new EdgeTopological(G);

        if (!top.isDAG())
            throw new Error("The given digraph is not a DAG.");

        for (int v : top.order())
            relax(G, v);

    }

    public void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (distTo[w] < distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }

    public boolean hasPathTo(int v){
        return distTo[v] > Double.NEGATIVE_INFINITY;
    }

    public double distTo(int v){
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if (!hasPathTo(v))
            return null;

        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);

        return path;
    }

}
