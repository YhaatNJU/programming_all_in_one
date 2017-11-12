package com.yha.question;

import java.util.Stack;

/**
 * @author yha
 * @decription 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @create 2017-11-11 22:59
 **/
public class QueueWithTwoStack {

    /**
     * 头队列，负责出队列
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    /**
     * 尾队列，负责入队列
     */
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack2.push(node);
    }

    public int pop() {
        if (stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

}
