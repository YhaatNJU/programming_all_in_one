package com.yha.question;

/**
 * @author yha
 * @Description 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @date 2017/11/12
 */
public class MirrorOfBinaryTree {


    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }



    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
