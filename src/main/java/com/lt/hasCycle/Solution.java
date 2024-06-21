package com.lt.hasCycle;

import com.lt.ListNode;

/**
 * @author Alan
 * @Description
 * @date 2024.05.21 20:30
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
