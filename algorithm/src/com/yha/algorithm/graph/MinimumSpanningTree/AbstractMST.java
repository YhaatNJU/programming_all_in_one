package com.yha.algorithm.graph.MinimumSpanningTree;

/**
 * @author yha
 * @decription 最小生成树的基类
 * @create 2017-10-28 14:23
 **/
public abstract class AbstractMST {

    /**
     * 获取最小生成树的所有边
     * @return
     */
    public abstract Iterable<Edge> edges();

    /**
     * 获取最小生成树的权重
     * @return
     */
    public abstract double weight();


}
