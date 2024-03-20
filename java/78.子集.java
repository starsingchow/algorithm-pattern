/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null) {
            return null;
        }

        List<Integer> list = new ArrayList();

        backtrack(nums, 0, nums.length, list, result);
        return result;
    }

    private void backtrack(int[] nums, int index, int nLen,List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList(list));

        for(int i = index; i < nLen; i++) {
            list.add(nums[i]);
            backtrack(nums, i+1, nLen, list, result);
            list.remove(list.size()-1);
        }
    }
}
// @lc code=end

