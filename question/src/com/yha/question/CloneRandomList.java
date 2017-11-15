package com.yha.question;

/**
 * @author yha
 * @Description 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @date 2017/11/15
 *
 * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
 * 2、遍历链表，A1->random = A->random->next;
 * 3、将链表拆分成原链表和复制后的链表
 */

public class CloneRandomList {

    public RandomListNode Clone(RandomListNode pHead) {

        if (pHead == null)
            return null;

        RandomListNode curNode = pHead;
        while (curNode != null){
            RandomListNode next = curNode.next;
            RandomListNode copy = new RandomListNode(curNode.label);
            copy.next = next;
            curNode.next = copy;
            curNode = next;
        }
        curNode = pHead;
        while (curNode != null){
            RandomListNode copy = curNode.next;
            if (curNode.random != null)
                copy.random = curNode.random.next;
            curNode = copy.next;
        }

        RandomListNode nHead = pHead.next;
        curNode = pHead;
        RandomListNode nCur = nHead;
        while (curNode != null){
            curNode.next = nCur.next;
            curNode = nCur.next;
            if (curNode == null)
                break;
            nCur.next = curNode.next;
            nCur = curNode.next;
        }
        return nHead;
    }

    public static void main(String[] args){
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = c;
        b.random = e;
        d.random = b;
        CloneRandomList clone = new CloneRandomList();
        clone.Clone(a);
    }


    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
