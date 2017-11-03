package com.yha.algorithm.string.regularExpressions;

import com.yha.algorithm.adt.bag.Bag;
import com.yha.algorithm.adt.bag.LinkedBag;
import com.yha.algorithm.adt.stack.Stack;
import com.yha.algorithm.graph.digraph.Digraph;
import com.yha.algorithm.graph.digraph.DirectedDFS;
import com.yha.algorithm.graph.digraph.FixedVertexDiGraph;

/**
 * @author yha
 * @Description 正则表达式的模式匹配（grep）
 * @date 2017/11/3
 */
public class NFA {

    /**
     * 匹配的转换
     */
    private char[] re;
    /**
     * epsilon转换
     */
    private Digraph G;
    /**
     * 状态数量
     */
    private int M;

    public NFA(String regexp){
        //根据给定的正则表达式钩子NFA
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new FixedVertexDiGraph(M + 1);

        for (int i = 0; i < M; i++){
            int lp = i;
            if (re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if (re[i] == ')'){
                int or = ops.pop();
                if (re[or] == '|'){
                    lp = ops.pop();
                    G.addEdge(lp, or+1);
                    G.addEdge(or, i);
                }else
                    lp = or;
            }

            if (i < M-1 && re[i+1] == '*'){ //查看下一个字符
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i+1);

        }
    }

    /**
     * 判断NFA是否能识别文本txt
     * @param txt
     * @return
     */
    public boolean recoginzes(String txt){
        Bag<Integer> pc = new LinkedBag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++)
            if (dfs.marked(v))
                pc.add(v);

        for (int i = 0; i < txt.length(); i++){
            //计算txt[i+1]可能到达的缩影NFA状态
            Bag<Integer> match = new LinkedBag<>();
            for (int v : pc)
                if (v < M)
                    if (re[v] == txt.charAt(i) || re[v] == '.')
                        match.add(v+1);
            pc = new LinkedBag<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++){
                if (dfs.marked(v))
                    pc.add(v);
            }
        }
        for (int v : pc)
            if (v == M)
                return true;
        return false;
    }

    public static void main(String[] args){
        NFA nfa = new NFA("(.*AB((C|D*E)F)G");
        System.out.println(nfa.recoginzes("DDEABCFG"));
    }
}
