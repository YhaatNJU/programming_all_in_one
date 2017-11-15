package com.yha.question;

import java.util.Stack;

/**
 * @author yha
 * @decription 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @create 2017-11-12 20:40
 **/
public class IsPopOrder {

    public boolean IsPopOrder(int [] pushA, int [] popA) {
        Stack<Integer> pushStack = new Stack<>();
        for (int i : pushA)
            pushStack.push(i);

        Stack<Integer> popStack = new Stack<>();
        for (int i = popA.length - 1; i >= 0; i--){
            popStack.push(popA[i]);
        }

        Stack<Integer> tempStack = new Stack<>();

        while (!pushStack.isEmpty() && !popStack.isEmpty()){
            int pop = popStack.pop();
            int push = pushStack.pop();
            while (pop != push){
                tempStack.push(push);
                if (pushStack.isEmpty())
                    return false;
                push = pushStack.pop();
            }

            if (tempStack.size() != 0 && tempStack.size() == popStack.size() && pushStack.isEmpty())
                return false;
            while (!tempStack.isEmpty() && !popStack.isEmpty()){
                push = tempStack.pop();
                pop = popStack.pop();
                if (pop != push){
                    popStack.push(pop);
                    pushStack.push(push);
                    while (!tempStack.isEmpty()){
                        pushStack.push(tempStack.pop());
                    }
                    break;
                }
            }
            if (tempStack.isEmpty() && popStack.isEmpty() && tempStack.isEmpty())
                return true;


        }
        if (!pushStack.isEmpty() || !popStack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args){

        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        IsPopOrder order = new IsPopOrder();
        System.out.println(order.IsPopOrder(push,pop));
    }
}
