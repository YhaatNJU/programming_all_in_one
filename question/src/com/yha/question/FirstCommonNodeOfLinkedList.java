package com.yha.question;

/**
 * @author yha
 * @Description 输入两个链表，找出它们的第一个公共结点。
 * @date 2017/11/16
 */
public class FirstCommonNodeOfLinkedList {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = lengthOfList(pHead1);

        int length2 = lengthOfList(pHead2);

        if (length1 == 0 || length2 == 0)
            return null;
        ListNode curNode1 = pHead1;
        ListNode curNode2 = pHead2;
        if (length1 > length2){
            int steps = length1 - length2;
            curNode1 = walkSteps(curNode1, steps);
        }else if (length2 > length1){
            int steps = length2 - length1;
            curNode2 = walkSteps(curNode2, steps);
        }
        while (curNode1 != null && curNode2 != null){
            if (curNode1 == curNode2){
                return curNode1;
            }
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }


        return null;
    }

    private ListNode walkSteps(ListNode node, int steps){
        if (node == null)
            return null;
        while (steps > 0 && node != null){
            node = node.next;
            steps --;
        }
        return node;
    }

    private int lengthOfList(ListNode node){
        int length = 0;
        while (node != null){
            length ++;
            node = node.next;
        }

        return length;
    }

    static void printListNode(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("NULL;");
        System.out.println();
    }

    public static void main(String[] args){
        FirstCommonNodeOfLinkedList first = new FirstCommonNodeOfLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);

        f.next = g;
        a.next = b;
        b.next = c;
        d.next = e;
        c.next = f;
        e.next = f;

        ListNode node = first.FindFirstCommonNode(a, d);
        printListNode(node);

    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
