/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = null;
        int i = 1;
        while(i < left) {
            pre = head;
            head = head.next;
            i++;
        }

        int j = i;
        ListNode next = null;
        ListNode mid = head;
        while(head != null && j <= right) {
            ListNode temp = head.next;
            head.next = next;
            next = head;
            head = temp;
            j++;
        }

        if(pre != null) {
            pre.next = next;
        } else {
            dummy.next = next;   
        }
        mid.next = head;
        return dummy.next;
    }
}
// @lc code=end

