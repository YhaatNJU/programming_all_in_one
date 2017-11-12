package com.yha.question;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yha
 * @decription 输入一个链表，从尾到头打印链表每个节点的值。
 * @create 2017-11-11 22:10
 **/
public class PrintLinkedListReversely {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> deque = new LinkedList();
        while (listNode != null){
            deque.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (deque.peek() != null){
            list.add(deque.pop());
        }
        return list;

    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
