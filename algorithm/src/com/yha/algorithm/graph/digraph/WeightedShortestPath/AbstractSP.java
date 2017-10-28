package com.yha.algorithm.graph.digraph.WeightedShortestPath;

/**
 * @author yha
 * @decription 最短路径基类
 * @create 2017-10-28 16:01
 **/
public abstract class AbstractSP {

    /**
     * 是否存在从顶点s到v的路径
     * @param v
     * @return
     */
    public abstract boolean hasPathTo(int v);

    /**
     * 从顶点s到顶点v的路径，不存在则返回null
     * @param v
     * @return
     */
    public abstract Iterable<DirectedEdge> pathTo(int v);

    /**
     * 从顶点s到顶点v的最短路径长度，不存在则返回无穷大
     * @param v
     * @return
     */
    public abstract double distTo(int v);

}
