package com.yha.algorithm.graph.unionFind;

/**
 * @author yha
 * @description 保证当且仅当id[p]等于id[q]时，p和q是连通的。换句话说，在同一个连通分量中
 * 的所有触点在id[]中的值必须全部相同。
 * 此时connected(p, q)只需判断id[p] == id[q]即可。
 * 为了实现上述想法，我们首先要检查p和q是否在同一连通分量中，如果在，则不采取任何行动；否则，我们需要将p和q所在的
 * 分量的所有触点的id[]值改成一致的，既可以全部改为id[p]的值，也可以全部改为id[q]的值
 * 优点：确定触点所在的分量非常快，quickFind由此而来
 * 确定：归并两个分量时需要遍历整个id[]数组
 * @create 2017-09-19 13:42
 **/

public class QuickFind extends UnionFind{

    public QuickFind(int N){
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        //将p和q归并到相同的分量中
        int pID = find(p);
        int qID = find(q);

        //如果p和q已经在相同的分量中，则不需采取任何行动
        if (pID == qID)
            return;

        //将p的分量重命名为q的名称
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID)
                id[i] = qID;
        }
        count--; //连通分量数量减少1
    }


}
