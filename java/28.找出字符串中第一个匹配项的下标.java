/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }

        int hLen = haystack.length();
        int nLen = needle.length();
        int i = 0;
        int j = 0;
        int temp = i;
        while(i < hLen && j < nLen) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == nLen) {
                    return temp;
                }
            } else {
                i = temp+1;
                j = 0;
                temp = i;
            }
        }

        return -1;
    }
}
// @lc code=end

