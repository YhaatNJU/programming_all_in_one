package com.yha.algorithm.graph.MinimumSpanningTree;

/**
 * Author:yha
 * Description:和计算最小生成树相关的边的表示
 * Time:2017/10/22 下午4:09.
 * Illustration:
 */
public class Edge implements Comparable<Edge>{
    
    private final int v; //顶点之一
    private final int w; //另一个顶点
    private final double weight; //边的权重
    private boolean visited = false; //标志这条边是否访问过，对于那些不需要重复边的应用非常重要，可以取代使用equals()方法
    
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    
    public double weight(){
        return weight;
    }
    
    public int either(){
        return v;
    }
    public int other(int vertex){
        if (vertex == v)
            return w;
        else if (vertex == w)
            return v;
        else
            throw new RuntimeException("Inconsistent edge.");
    }
    
    @Override
    public int compareTo(Edge that) {
        if (this.weight() < that.weight())
            return -1;
        else if (this.weight() > that.weight())
            return +1;
        else
            return 0;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (Double.compare(edge.weight, weight) != 0)
            return false;
        if (v == edge.v && w == edge.w)
            return true;
        if (v == edge.w && w == edge.v)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        int min = v;
        if (other(v) < min)
            min = other(v);
        result = min;
        result = 31 * result + other(min);
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString(){
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
