package com.yha.question;

/**
 * @author yha
 * @Description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @date 2017/11/12
 */
public class MergeLinkedList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode root = null;
        ListNode cur = null;
        if (list1.val <= list2.val){
            cur = root = list1;
            list1 = list1.next;
        }else {
            cur = root = list2;
            list2 = list2.next;
        }
        while (list1 != null || list2 != null){
            if (list1 == null){
                cur.next = list2;
                list2 = list2.next;
            }else if (list2 == null){
                cur.next = list1;
                list1 = list1.next;
            }else {
                if (list1.val <= list2.val){
                    cur.next = list1;
                    list1 = list1.next;
                }else {
                    cur.next = list2;
                    list2 = list2.next;
                }
            }
            cur = cur.next;
        }
        return root;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
