// https://leetcode.com/problems/find-the-middle-index-in-array

class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int val: nums) sum += val;
        for(int i=0;i<nums.length;i++){
            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        
        return -1;
    }
}