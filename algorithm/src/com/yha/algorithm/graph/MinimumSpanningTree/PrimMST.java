package com.yha.algorithm.graph.MinimumSpanningTree;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;
import com.yha.algorithm.adt.priorityQueue.IndexMiniPQ;
import com.yha.algorithm.adt.queue.Queue;

import java.security.Key;

/**
 * @author www
 * @Description: 最小生成树的Prim算法（及时实现）
 * @create 2017/10/27
 */
public class PrimMST extends AbstractMST{

    private Edge[] edgeTo; //距离树最近的边
    private double[] distTo; //distTo[w]=edgeTo[w].weight()
    private boolean[] marked; //如果v在树种则为true
    private IndexMiniPQ<Double> pq; //有效的横切边
    private double weight = 0.0; //所有边的权重

    public PrimMST(EdgeWeightGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMiniPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0); //用顶点0和权重0初始化pq
        while (!pq.isEmpty()){
            visit(G, pq.delMin());
        }


    }

    public void visit(EdgeWeightGraph G, int v){
        //将顶点v添加到树中，更新数据
        marked[v] = true;
        for (Edge e : G.adj(v)){
            int w = e.other(v);

            if (marked[w])  //v-w失效
                continue;
            if (e.weight() < distTo[w]){
                //连接w和树的最佳边Edge变为e
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
        weight += distTo[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> mst = new LinkedBag<>();
        for (int v = 1; v < edgeTo.length; v++)
            mst.add(edgeTo[v]);

        return mst;
    }

    public double weight(){
        return weight;
    }

}
