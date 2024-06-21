package com.lt.cutNode;

import com.lt.ListNode;

/**
 * @author Alan
 * @Description
 * @date 2024.05.20 19:57
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        ListNode partition = partition(listNode, 2);
        for (ListNode node = partition; node != null; node = node.next) {
            System.out.println(node.val);
        }

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode();
        ListNode gt = new ListNode();
        ListNode gtDummy = gt;
        ListNode ltDummy = lt;

        while (head != null) {
            if (head.val >= x){
                gt.next = head;
                gt = gt.next;
            }else{
                lt.next = head;
                lt = lt.next;
            }
            head = head.next;
        }
        gt.next = null;
        lt.next = gtDummy.next;
        return ltDummy.next;
    }
}
