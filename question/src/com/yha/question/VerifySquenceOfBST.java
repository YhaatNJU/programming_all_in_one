package com.yha.question;

/**
 * @author yha
 * @Description 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @date 2017/11/15
 */
public class VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        int curRoot = sequence.length - 1;
        int target = sequence[curRoot];
        int curStart = 0;
        int start = sequence[curStart];
        int tempStart = curStart;
        while (true){
            if (tempStart == curRoot)
                break;
            while (start < target && curStart < curRoot){
                curStart++;
                start = sequence[curStart];
            }
            if (curStart == curRoot){
                curRoot--;
                start = sequence[curRoot];
                curStart = tempStart;
                start = sequence[curStart];
                continue;
            }
            boolean less = hasLess(target, sequence, curStart, curRoot-1);
            if (less)
                return false;
            curRoot--;
            tempStart = curStart;
        }

        return true;
    }

    private boolean hasLess(int target, int[] sequence, int begin, int end){
        if (begin >= end)
            return false;

        for (int i = begin; i <= end; i++){
            if (sequence[i] < target)
                return true;
        }

        return false;
    }

    public static void main(String[] args){

        VerifySquenceOfBST bst = new VerifySquenceOfBST();
        int[] sequence = {4,8,6,12,16,14,10};
        System.out.println(bst.VerifySquenceOfBST(sequence));
    }
}
