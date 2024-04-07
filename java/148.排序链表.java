/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } 

        return slow;
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }

            head = head.next;
        }

        if(node1 != null) {
            head.next = node1;
        }

        if(node2 != null) {
            head.next = node2;
        }

        return dummy.next;
    }

    public ListNode mergeSort(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode middleNode = findMiddle(node);
        ListNode middleNodeNext = middleNode.next;
        middleNode.next = null;
        
        ListNode node1 = mergeSort(node);
        ListNode node2 = mergeSort(middleNodeNext);
        
        return mergeTwoLists(node1, node2);
    }
}
// @lc code=end

