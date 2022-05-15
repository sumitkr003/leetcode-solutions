// https://leetcode.com/problems/max-consecutive-ones

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0, count =0;
        for(int j=0;j<nums.length;j++){
            if(nums[j] == 0){
                ans = Math.max(ans, count);
                count = 0;
            }else{
                count ++;
            }
        }
        return Math.max(ans, count);
    }
}