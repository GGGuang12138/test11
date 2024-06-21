package com.lt.mergeNode;

import com.lt.ListNode;

/**
 * @author Alan
 * @Description
 * @date 2024.05.16 20:46
 */
public class Solution {

    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        ListNode dummy = new ListNode(-1);
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                dummy.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                dummy.next = pHead2;
                pHead2 = pHead2.next;
            }
            dummy = dummy.next;
        }
        while (pHead1 != null){
            dummy.next = pHead1;
            pHead1 = pHead1.next;
            dummy = dummy.next;
        }
        while (pHead2 != null){
            dummy.next = pHead2;
            pHead2 = pHead2.next;
            dummy = dummy.next;
        }
        return dummy.next;

    }
}
