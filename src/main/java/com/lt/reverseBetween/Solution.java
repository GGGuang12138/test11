package com.lt.reverseBetween;

import com.lt.ListNode;

/**
 * @author Alan
 * @Description
 * @date 2024.01.12 22:39
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    /**
     * 反转n个元素
     */
    ListNode tail = null;
    public ListNode reverseN(ListNode head, int n){
        if(n == 1){
            // 需要把最后的尾巴存下来
            tail = head.next;
            return head;
        }
        // 递归反转得到新的头节点
        ListNode newHead = reverseN(head.next,n-1);
        // 当前节点的指向需要修改
        head.next.next = head;
        head.next = tail;
        return newHead;
    }

        public ListNode reverseBetween2(ListNode head, int left, int right) {
            // 定位出四个关键节点
            ListNode leftBefore = null;
            ListNode leftNode = null;
            ListNode rightAfter = null;
            ListNode rightNode = head;

            // 通过快慢指针进行反转
            ListNode fast = head;
            ListNode slow =null;
            int index = 1;
            while(index <= right){
                ListNode next = fast.next;
                if(index == left){
                    leftBefore = slow;
                    leftNode = fast;
                }
                if(index >= left){
                    fast.next = slow;
                }
                slow = fast;
                fast = next;
                index ++;
            }
            rightAfter = fast;
            rightNode = slow;
            leftNode.next = rightAfter;
            // 四个关键节点进行返回
            if(leftBefore == null){
                return rightNode;
            }
            leftBefore.next = rightNode;
            return head;
        }

}
