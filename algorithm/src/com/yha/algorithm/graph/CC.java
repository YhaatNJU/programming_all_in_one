package com.yha.algorithm.graph;

/**
 * @author yha
 * @decription 查找连通分量的基类
 * @create 2017-09-24 21:00
 **/
public abstract class CC {

    /**
     * v和w是否连通
     * @param v
     * @param w
     * @return
     */
    public abstract boolean connected(int v, int w);

    /**
     * 连通分量的数量
     * @return
     */
    public abstract int count();

    /**
     * v所在的连通分量的标识符(0 -- count()-1)
     * @param v
     * @return
     */
    public abstract int id(int v);

}
