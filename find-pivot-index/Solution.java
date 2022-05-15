// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int val: nums) sum += val;
        for(int i=0;i<nums.length;i++){
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        
        return -1;
    }
}