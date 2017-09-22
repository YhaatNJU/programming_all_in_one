package com.yha.algorithm.graph.unionFind;

import java.util.Scanner;

/**
 * @author yha
 * @decription UnionFind测试类
 * @create 2017-09-19 21:40
 **/
public class UnionFindTest {

    private static final String TEST_INPUT = "10 11  4 3  3 8  6 5  9 4  2 1  8 9  5 0  7 2  6 1  1 0  6 7";

    private static final String TEST_OUTPUT = "4 3  3 8  6 5  9 4  2 1  5 0  7 2  6 1";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //触点个数
        int n = scanner.nextInt(); //触点对对数

        //UnionFind unionFind = new QuickFind(N);
        //UnionFind unionFind = new QuickUnion(N);
        UnionFind unionFind = new WeightedQuickUnion(N);
        int p = 0;
        int q = 0;
        int i = n;
        while (i > 0){
            p = scanner.nextInt();
            q = scanner.nextInt();
            if (unionFind.connected(p, q))
                continue;
            unionFind.union(p ,q);
            System.out.println(p + " " + q);
            i--;
        }
    }

}
