package com.yha.question;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author yha
 * @Description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @date 2017/11/15
 */
public class ConvertBinaryToDeque {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(pRootOfTree);
        Queue<TreeNode> orderNodes = new LinkedList<>();
        while (!nodes.isEmpty()){
            TreeNode cur = nodes.pop();
            if (cur.left == null){
                orderNodes.add(cur);
                if (cur.right != null)
                    nodes.push(cur.right);
            }else {
                if (cur.right != null)
                    nodes.push(cur.right);
                TreeNode left = cur.left;
                cur.left = null;
                cur.right = null;
                nodes.push(cur);
                nodes.push(left);
            }
        }


        TreeNode head = orderNodes.poll();
        if (orderNodes.size() == 1)
            return head;

        TreeNode cur = orderNodes.poll();
        TreeNode pre = head;


        while (cur != null){
            pre.right = cur;
            cur.left = pre;
            pre = cur;
            cur = orderNodes.poll();
        }
        return head;

    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        ConvertBinaryToDeque convert = new ConvertBinaryToDeque();
        TreeNode d = convert.Convert(a);
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
