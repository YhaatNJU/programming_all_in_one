package com.yha.question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yha
 * @Description 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @date 2017/11/15
 */
public class PathOfSum {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        return findPathCore(root, target, 0, new ArrayList<>());

    }

    private ArrayList<ArrayList<Integer>> findPathCore(TreeNode root, int target, int current,
                                                       ArrayList<Integer> path){

        if (root == null)
            return new ArrayList<>();
        if (current + root.val > target)
            return null;

        ArrayList<Integer> tempPath = new ArrayList<>(path.size());
        tempPath.addAll(path);
        tempPath.add(root.val);

        if (current + root.val == target){
            if (root.left != null || root.right != null)
                return null;
            ArrayList<ArrayList<Integer>> re = new ArrayList<>();

            re.add(tempPath);
            return re;
        }

        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if (root.left != null){
            ArrayList<ArrayList<Integer>> child = findPathCore(root.left, target, current + root.val, tempPath);
            if (child != null)
                re.addAll(child);
        }
        if (root.right != null){
            ArrayList<ArrayList<Integer>> child = findPathCore(root.right, target, current + root.val, tempPath);
            if (child != null)
                re.addAll(child);
        }

        return re;
    }

    public static void main(String[] args){


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
