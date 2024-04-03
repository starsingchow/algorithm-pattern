/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int maxPathSum(TreeNode root) {
        int[] result = maxPathSumDepth(root);
        return result[0];
    }

    
    public int[] maxPathSumDepth(TreeNode root) {
        if(root == null) {
            // 第一位为两边最大值, 第二位为单边最大值
            return new int[]{Integer.MIN_VALUE, 0};
        }

        int[] left = maxPathSumDepth(root.left);
        int[] right = maxPathSumDepth(root.right);

        int[] result = new int[2];
    
        // 求单边最大值
        if(left[1] > right[1]) {
            result[1] = Math.max(left[1]+root.val, 0);
        } else {
            result[1] = Math.max(right[1]+root.val, 0);
        }

        // 求两边加根最大值
        result[0] = Math.max(left[1]+right[1]+root.val, Math.max(left[0], right[0]));
        return result;
    }
}
// @lc code=end

