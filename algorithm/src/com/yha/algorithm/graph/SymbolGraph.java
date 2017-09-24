package com.yha.algorithm.graph;

import com.yha.algorithm.adt.symbolTable.LinkedST;
import com.yha.algorithm.adt.symbolTable.SymbolTable;

import java.util.Scanner;

/**
 * @author yha
 * @decription 符号图（顶点都是字符串而不是数字的图）
 * 只需处理好字符串顶点和数字顶点的映射就可以实现了
 * @create 2017-09-24 22:26
 **/
public class SymbolGraph {

    private SymbolTable<String, Integer> st; //符号名->索引
    private String[] keys; //索引->符号名
    private Graph G; //图

    public SymbolGraph(String stream, String sp) {
        st = new LinkedST<>();
        Scanner scanner = new Scanner(stream); //第一遍
        while (scanner.hasNextLine()) { //构造索引
            String[] a = scanner.nextLine().split(sp); //读取字符串
            for (int i = 0; i < a.length; i++) { //为每个不同的字符串关联一个索引
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()]; //用来获得顶点名的反向索引是一个数组
        for (String name : st.keys())
            keys[st.get(name)] = name;

        G = new FixedVertexGraph(st.size());
        scanner = new Scanner(stream); //第二遍
        while (scanner.hasNextLine()) { //构造图
            String[] a = scanner.nextLine().split(sp); //将每一行的顶点和该行的其他顶点相连
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }
    }

    /**
     * key是否是一个顶点
     * @param key
     * @return
     */
    public boolean contains(String key){
        return st.contains(key);
    }

    /**
     * key的索引
     * @param key
     * @return
     */
    public int index(String key){
        return st.get(key);
    }

    /**
     * 索引v的顶点名
     * @param v
     * @return
     */
    public String name(int v){
        return keys[v];
    }

    /**
     * 隐藏的Graph对象
     * @return
     */
    public Graph G(){
        return G;
    }
}
