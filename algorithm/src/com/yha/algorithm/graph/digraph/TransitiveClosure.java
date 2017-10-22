package com.yha.algorithm.graph.digraph;

/**
 * Author:yha
 * Description:使用深度优先算法实现的计算传递闭包的算法
 * 不适合大型有向图
 * 所需空间和V²成正比
 * 所需时间和V(V+E)成正比
 * Time:2017/10/22 下午3:25.
 * Illustration:
 */
public class TransitiveClosure {
    
    private DirectedDFS[] all;
    
    public TransitiveClosure(Digraph G){
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++){
            all[v] = new DirectedDFS(G, v);
        }
    }
    
    public boolean reachable(int v, int w){
        return all[v].marked(w);
    }
}
