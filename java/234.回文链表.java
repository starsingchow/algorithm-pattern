/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverse(slow.next);
        slow.next = null;

        while(head != null && tail != null) {
            if(head.val != tail.val) {
                return false;
            }

            head = head.next;
            tail = tail.next;
        }

        return true;
        
    }

    private ListNode reverse(ListNode node) {
        if(node == null) return null;

        ListNode dummy = new ListNode();
        while(node != null) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
        }

        return dummy.next;
    }
    
    
}
// @lc code=end

