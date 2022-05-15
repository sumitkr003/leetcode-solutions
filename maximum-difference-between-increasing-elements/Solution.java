// https://leetcode.com/problems/maximum-difference-between-increasing-elements

class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int curr = nums[0];
        for(int i=1;i<nums.length;i++){
            ans = nums[i] > curr ? Math.max(ans, nums[i] - curr) : ans;
            curr = Math.min(curr, nums[i]);
        }
        return ans;
    }
}