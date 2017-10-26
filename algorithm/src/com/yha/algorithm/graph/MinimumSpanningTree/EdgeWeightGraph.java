package com.yha.algorithm.graph.MinimumSpanningTree;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;

/**
 * Author:yha
 * Description:加权无向图的数据类型
 * Time:2017/10/22 下午4:21.
 * Illustration:
 */
public class EdgeWeightGraph {
    
    private final int V; //顶点总数
    private int E; //边的总数
    private Bag<Edge>[] adj; //临接表
    
    public EdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedBag<>();
    }
    
    public int V(){
        return V;
    }

    public int E(){
        return E;
    }
    
    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    
    public Iterable<Edge> edges(){
        Bag<Edge> allEdges = new LinkedBag<>();
        for (int i = 0; i < V; i++){
            adj[i].forEach(allEdges::add);
        }
        return allEdges;
    }
}
