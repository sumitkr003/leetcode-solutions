// https://leetcode.com/problems/move-zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length && j < nums.length){
            if(j < i){
                j++;   
            }else if(nums[i] == 0 && nums[j] != 0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
                j++;
            }else if(nums[i] != 0){
                i++;    
            }else if(nums[j] == 0){
                j++;
            }
        }
    }
}