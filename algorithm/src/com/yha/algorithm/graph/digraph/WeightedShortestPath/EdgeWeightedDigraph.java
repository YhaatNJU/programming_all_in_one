package com.yha.algorithm.graph.digraph.WeightedShortestPath;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;

/**
 * @author yha
 * @decription 加权有向图的数据类型
 * @create 2017-10-28 15:54
 **/
public class EdgeWeightedDigraph {

    private final int V; //顶点总数
    private int E; //边的总数
    private Bag<DirectedEdge>[] adj; //邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new LinkedBag<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> bag = new LinkedBag<>();
        for (int v = 0; v < V; v++){
            adj[v].forEach(bag::add);
        }

        return bag;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
}
