package com.yha.question;

/**
 * @author yha
 * @decription 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @create 2017-11-11 22:17
 **/
public class ReBuildBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre == null || in == null)
            return null;
        if (pre.length != in.length)
            return null;

        int rootVal = pre[0];
        int subTrees = 0;
        for (int j = 0; j < in.length; j++){
            if (rootVal == in[j]){
                break;
            }
            subTrees++;
        }
        TreeNode root = new TreeNode(pre[0]);
        root.left = reBuild(pre, 1, subTrees, in, 0, subTrees - 1);
        root.right = reBuild(pre, subTrees + 1, pre.length - 1, in, subTrees + 1, in.length - 1);

        return root;
    }


    private TreeNode reBuild(int[] pre, int pS, int pE, int[] in, int iS, int iE){
        if (pS > pE)
            return null;
        if (pS == pE)
            return new TreeNode(pre[pS]);
        int rootVal = pre[pS];
        int subTrees = 0;
        for (int j = iS; j < iE; j++){
            if (rootVal == in[j]){
                break;
            }
            subTrees++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = reBuild(pre, pS + 1, pS + subTrees, in, iS, iS + subTrees - 1);
        root.right = reBuild(pre, pS + subTrees + 1, pE, in, iS + subTrees + 1, iE);
        return root;
    }
}


/**
 * Definition for binary tree
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

