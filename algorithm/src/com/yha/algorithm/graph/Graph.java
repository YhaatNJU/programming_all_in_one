package com.yha.algorithm.graph;

/**
 * Author:yha
 * Description:无向图基类
 * Time:2017/9/24 下午2:53.
 * Illustration:
 */
public abstract class Graph {
    
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
     * 向图中添加一条边v-w
     * @param v
     * @param w
     */
    public abstract void addEdge(int v, int w);
    
    /**
     * 和顶点相邻的所有顶点
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
     * 计算v的度数
     * @param G
     * @param v
     * @return
     */
    public static int degree(Graph G, int v){
        int degree = 0;
        for (int w : G.adj(v))
            degree ++;
        return degree;
    }
    
    /**
     * 计算所有顶点的最大度数
     * @param G
     * @return
     */
    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++){
            if (degree(G, v) > max)
                max = degree(G, v);
        }
        
        return max;
    }
    
    /**
     * 计算所有顶点的平均度数
     * @param G
     * @return
     */
    public static double avgDegree(Graph G){
        return 2.0 * G.E() / G.V();
    }
    
    /**
     * 计算自环的个数
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G){
        int count = 0;
        for (int v = 0; v < G.V(); v++){
            for (int w : G.adj(v)){
                if (v == w)
                    count++;
            }
        }
        
        return count/2; //每条边都被计算了两次
    }
}
