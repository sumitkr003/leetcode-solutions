// https://leetcode.com/problems/number-of-ways-to-split-array

class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        long sum = 0;
        long leftSum = 0;
        for(int val: nums) sum += (long)val;
        for(int i=0;i<nums.length-1;i++){
            leftSum += (long)nums[i];
            if(leftSum >= sum - leftSum){
                ans ++;
            }
        }
        return ans;
    }
}