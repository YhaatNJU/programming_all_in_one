package com.yha.algorithm.graph.digraph;

/**
 * @author yha
 * @decription 有向图基类
 * @create 2017-09-24 23:12
 **/
public abstract class Digraph{


    /**
     * 顶点数
     * @return
     */
    public abstract int V();

    /**
     * 边数
     * @return
     */
    public abstract int E();

    /**
     * 向图中添加一条边v->w
     * @param v
     * @param w
     */
    public abstract void addEdge(int v, int w);

    /**
     * 由顶点指出的边总数
     * @param v
     * @return
     */
    public abstract Iterable<Integer> adj(int v);

    /**
     * 对象的字符串表示
     * @return
     */
    public String toString(){
        String s = V() + " vertices," + E() + " edges\n";
        for (int v = 0; v < V(); v++){
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }

        return s;
    }

    /**
     * 该图的反向表示
     * @return
     */
    public abstract Digraph reverse();

}
