package com.yha.question;

/**
 * @author yha
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @date 2017/11/12
 */
public class FindKthToTail {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null)
            return null;
        if (k <= 0)
            return null;
        ListNode front = head;
        while (k > 1){
            front = front.next;
            k--;
            if (front == null)
                return null;
        }
        ListNode back = head;
        while (front.next != null){
            front = front.next;
            back = back.next;
        }

        return back;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}

