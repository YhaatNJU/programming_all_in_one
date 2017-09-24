package com.yha.algorithm.graph;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;

import java.util.Scanner;

/**
 * Author:yha
 * Description:使用Bag实现的固定顶点数的邻接表无向图
 * Time:2017/9/24 下午3:12.
 * Illustration:
 */
public class FixedVertexGraph extends Graph {
    
    private final int V;  //顶点个数
    private int E; //边的数目
    private Bag<Integer>[] adj; //邻接表
    
    public FixedVertexGraph(int vertices) {
        V = vertices;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V]; //创建邻接表
        for (int v = 0; v < V; v++) //将所有链表初始化为空
            adj[v] = new LinkedBag<>();
    }
    
    public FixedVertexGraph(Scanner scanner) {
        this(scanner.nextInt()); //读取V并将图初始化
        int E = scanner.nextInt(); // 读取E
        
        for (int i = 0; i < E; i++){
            //添加一条边
            int v = scanner.nextInt(); // 读取一个顶点
            int w = scanner.nextInt(); //读取另一个顶点
            addEdge(v, w); //添加一条连接它们的边
        }
    }
    
    @Override
    public int V() {
        return V;
    }
    
    @Override
    public int E() {
        return E;
    }
    
    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    
    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
