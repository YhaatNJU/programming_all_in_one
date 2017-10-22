package com.yha.algorithm.graph.MinimumSpanningTree;

import com.yha.algorithm.adt.priorityQueue.MinPQ;
import com.yha.algorithm.adt.queue.Queue;

/**
 * @author yha
 * @decription 最小生成树的Prim算法的延时实现
 * @create 2017-10-22 21:11
 **/
public class LazyPrimMST {

    private boolean[] marked; // 最小生成树的顶点
    private Queue<Edge> mst; // 最小生成树的边
    private MinPQ<Edge> pq; // 横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightGraph G){
        int size = 0;
        for (Edge e : G.edges())
            size++;
        pq = new MinPQ<>(size);
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0); //假设G是连通的
        while (!pq.isEmpty()){
            //pq.show();
            Edge e = pq.delMin(); //从pq中取得权重最小的边
            //System.out.println("min: " +e);
            int v = e.either(), w = e.other(v); //跳过失效的边
            if (marked[v] && marked[w])
                continue;
            mst.enqueue(e); //将边添加到树中
            if (!marked[v]) //将顶点（v或w）添加的树中
                visit(G, v);
            if (!marked[w])
                visit(G, w);
        }
    }


    private void visit(EdgeWeightGraph G, int v){
        //标记顶点v并将所要连接v且未被标记的顶点加入pq

        marked[v] = true;
        for (Edge e : G.adj(v)){
            if (!marked[e.other(v)]){
                pq.insert(e);
                //pq.show();
            }
        }

    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double sum = 0;
        for (Edge e : edges())
            sum += e.weight();
        return sum;
    }

}
