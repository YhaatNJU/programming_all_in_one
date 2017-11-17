package com.yha.question;

/**
 * @author yha
 * @Description 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @date 2017/11/17
 */
public class IsBalancedBinaryTree {

    private static int depth = 0;

    public boolean IsBalanced_Solution(TreeNode root) {

        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode root){
        if (root == null){
            depth = 0;
            return true;
        }
        boolean left = isBalanced(root.left);
        int leftDepth = depth;
        boolean right = isBalanced(root.right);
        int rightDepth = depth;
        depth = Math.max(leftDepth + 1, rightDepth + 1);
        if (left && right && (Math.abs(leftDepth - rightDepth) <= 1))
            return true;
        return false;
    }




    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
