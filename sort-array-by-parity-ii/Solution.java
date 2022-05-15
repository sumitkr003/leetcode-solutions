// https://leetcode.com/problems/sort-array-by-parity-ii

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0, j=nums.length-1;
        while(i < j){
            if(nums[i] % 2 == 0){
                i++;
            }else if(nums[j] % 2 == 1){
                j--;
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        // for(int val: nums) System.out.print(val + " ");
        for(i=1;i<nums.length/2;i+=2){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        return nums;
    }
}