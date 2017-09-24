package com.yha.algorithm.graph;


import java.util.Iterator;

/**
 * @author yha
 * @decription 和图搜索路径相关方法的基类
 * @create 2017-09-24 18:01
 **/
public abstract class Paths {


    /**
     * 是否存在从s到v的路径
     * @param v
     * @return
     */
    public abstract boolean hasPathTo(int v);

    /**
     * s到v的路径，如果不存在则返回null
     * @param v
     * @return
     */
    public abstract Iterable<Integer> pathTo(int v);

    public void showPath(int v){
        Iterable<Integer> integers = pathTo(v);
        if (integers == null){
            return;
        }
        Iterator<Integer> iterator = integers.iterator();
        if (iterator.hasNext()){
            System.out.print(iterator.next());
        }else {
            return;
        }
        while (iterator.hasNext()){
            System.out.print("->" + iterator.next());
        }
        System.out.println();
    }
}
