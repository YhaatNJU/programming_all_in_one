package com.yha.question;

/**
 * @author yha
 * @Description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @date 2017/11/12
 */
public class IsSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        return check(root1, root2);
    }

    private boolean check(TreeNode root1, TreeNode root2){
        TreeNode equalNode = find(root1, root2);
        if (equalNode == null)
            return false;
        boolean result = equal(equalNode, root2);
        if (result)
            return result;
        if (equalNode.left != null && equalNode.val == equalNode.left.val)
            result = check(root1.left, root2);
        if (result)
            return result;
        if (equalNode.right != null && equalNode.val == equalNode.right.val)
            result = check(root1.right, root2);
        return result;
    }


    private boolean equal(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 != null)
            return false;
        if (root1 != null && root2 == null)
            return true;
        if (root1 == null && root2 == null)
            return true;
        if (root1.val == root2.val){
            return equal(root1.left, root2.left) && equal(root1.right, root2.right);
        }else {
            return false;
        }
    }

    private TreeNode find(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null)
            return null;
        if (root1.val == root2.val)
            return root1;
        if (root2.val < root1.val)
            return find(root1.left, root2);
        else
            return find(root1.right, root2);
    }

    public static void main(String[] args){
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
