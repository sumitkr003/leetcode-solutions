// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int maxVal = nums[0];
        for(int i=0;i<nums.length;i++){
            if(maxVal < i) return false;
            maxVal = Math.max(maxVal, i+nums[i]);
            if(maxVal >= nums.length) return true;
        }
        
        // System.out.println(maxVal);
        return maxVal >= nums.length-1;
    }
}