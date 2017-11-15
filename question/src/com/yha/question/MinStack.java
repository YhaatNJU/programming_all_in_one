package com.yha.question;

import java.util.Stack;

/**
 * @author yha
 * @decription 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * @create 2017-11-12 20:08
 **/
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    public MinStack() {
        dataStack = new Stack();
        minStack = new Stack<>();
    }

    public void push(int node) {
        if (dataStack.isEmpty()){
            dataStack.push(node);
            minStack.push(node);
        }else {
            dataStack.push(node);
            int min = minStack.peek();
            if (node <= min)
                minStack.push(node);
            else
                minStack.push(min);

        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
