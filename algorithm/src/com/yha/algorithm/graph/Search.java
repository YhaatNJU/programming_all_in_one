package com.yha.algorithm.graph;

/**
 * @author yha
 * @decription 和图搜索顶点相关方法的基类
 * @create 2017-09-24 18:10
 **/
public abstract class Search {

    /**
     * 顶点v和s是否相连
     * @param w
     * @return
     */
    public abstract boolean marked(int w);

    /**
     * 与s连通的顶点总数
     * @return
     */
    public abstract int count();

}
