package com.yha.algorithm.graph.MinimumSpanningTree;

import com.yha.algorithm.adt.priorityQueue.MinPQ;
import com.yha.algorithm.adt.queue.Queue;
import com.yha.algorithm.graph.unionFind.QuickFind;
import com.yha.algorithm.graph.unionFind.UnionFind;

/**
 * @author yha
 * @decription 最小生成树的Kruskal算法
 * @create 2017-10-28 14:10
 **/
public class KruskalMST extends AbstractMST{

    private Queue<Edge> mst;
    private double weight; //生成树的权重

    public KruskalMST(EdgeWeightGraph G){
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>(G.E());
        G.edges().forEach(e -> pq.insert(e));

        UnionFind uf = new QuickFind(G.V());

        while (!pq.isEmpty() && mst.size() < G.V()-1){
            Edge e = pq.delMin(); //从pq中得到权重最小的边和它的顶点
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w))
                continue; //忽略失效的边
            uf.union(v, w);
            mst.enqueue(e);
            weight += e.weight();
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }


}
