package com.yha.algorithm.graph.digraph;

import com.yha.algorithm.adt.queue.Queue;
import com.yha.algorithm.adt.stack.Stack;
import com.yha.algorithm.graph.Paths;

/**
 * @author yha
 * @decription 使用广度优先算法的有向图最短路径搜索的类
 * @create 2017-10-22 10:47
 **/
public class DirectedBFP extends Paths{

    private boolean[] marked; //到达该顶点的最短路径是否已知
    private int[] edgeTo; //到达该顶点的已知路径上最后一个顶点
    private final int s; // 起点

    public DirectedBFP(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Digraph G, int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true; //标记起点
        queue.enqueue(s); //将起点价加入队列
        while (!queue.isEmpty()){
            int v = queue.dequeue(); //从队列中取出一个顶点
            for (int w : G.adj(v)){
                if (!marked[w]){ //对于每个未被标记的相邻顶点
                    edgeTo[w] = v; //保存最短路径的最后一条边
                    marked[w] = true; //标记它，因为最短路径已知
                    queue.enqueue(w); //将它添加到队列中
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}
