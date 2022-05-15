// https://leetcode.com/problems/next-permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        for(int i=n-2;i>=0;i--){
            int k = i;
            for(int j=i+1;j<n;j++){
                if(nums[j] > nums[i]){
                    k = k != i && nums[k] < nums[j] ? k : j;
                }
            }
            if(k != i){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                Arrays.sort(nums, i+1, n);
                flag = false;
                break;
            }
        }
        
        if(flag){
            Arrays.sort(nums);
        }
    }
}