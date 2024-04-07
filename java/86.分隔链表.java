/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode node1 = new ListNode();
        ListNode curr1 = node1;
        ListNode node2 = new ListNode();
        ListNode curr2 = node2;

        while(head != null) {
            if(head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }

            head = head.next;
        }

        curr1.next = node2.next;
        curr2.next = null;
        return node1.next;
    }
}
// @lc code=end

