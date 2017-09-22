package com.yha.algorithm.graph.unionFind;

/**
 * @author yha
 * @decription 每一个触点对于的id[]元素多少同一个分量中另一个触点的名称（即索引），或者是自己，即链接
 * 在union操作中，我们通过给的触点找到该触点所在的下一个触点，再由这个触点找到第三个触点，以此类推，直到到达一个根触点，
 * 即一个指向自己的触点。
 * 当且仅当由两个触点开始到达同一个根触点，才认为这两个触点是相连的。
 * 进行union操作是，只需将一个触点所在分量的根触点连接到另一个触点所在的分量的根触点即可
 * @create 2017-09-19 22:04
 **/
public class QuickUnion extends UnionFind{

    public QuickUnion(int N){
        super(N);
    }

    @Override
    public int find(int p) {
        //找出分量的名称（根触点的id[]值）
        while (p != id[p])
            p = id[p];

        return p;
    }

    @Override
    public void union(int p, int q) {
        //将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        id[pRoot] = qRoot;

        count--;
    }
}
