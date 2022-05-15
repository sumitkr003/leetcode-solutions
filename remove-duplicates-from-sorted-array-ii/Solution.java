// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1, curr = nums[0], count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == curr){
                count ++;
            }else{
                curr = nums[i];
                count = 1;
            }
            nums[index] = nums[i];
            nums[i] = curr;
            if(count <= 2) index++;
        }
        
        return index;
    }
}