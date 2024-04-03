/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root) == -1) return false;
        return true;
    }

    private int maxDepth(TreeNode node) {
        if(node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if(left == -1 || right == -1 || left-right > 1 || right-left > 1) {
            return -1;
        }

        if(left > right) {
            return left+1;
        }
        return right+1;
    }
}
// @lc code=end

