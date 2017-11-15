package com.yha.question;

import java.util.*;

/**
 * @author yha
 * @decription 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @create 2017-11-14 21:13
 **/
public class PrintBinaryTreeTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null)
            return nodes;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            TreeNode node = treeNodes.poll();
            nodes.add(node.val);
            if (node.left != null)
                treeNodes.add(node.left);
            if (node.right != null)
                treeNodes.add(node.right);
        }
        return nodes;
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
