package com.lt.mergeKLists;

import com.lt.ListNode;

import java.util.ArrayList;

/**
 * @author Alan
 * @Description
 * @date 2024.05.21 11:48
 */
public class Solution {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode ptr = new ListNode();
        ListNode dummyHead = ptr;
        while (!lists.isEmpty()){
            ArrayList<ListNode> next = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            ListNode minNode = null;
            // 找到当前最小的和下一轮要检查的
            for (ListNode node : lists){
                if (node != null){
                    if (node.val < min){
                        min = node.val;
                        minNode = node;
                    }
                    next.add(node);
                }
            }
            if (minNode != null){
                next.remove(minNode);
                if (minNode.next != null){
                    next.add(minNode.next);
                }
            }
            // 接入当前最小
            ptr.next = minNode;
            ptr = ptr.next;
            // 下一轮继续检查
            lists = next;
        }
        return dummyHead.next;
    }
}
