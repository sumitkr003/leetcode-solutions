// https://leetcode.com/problems/target-sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSum(nums, 0, 0, target);
    }
    
    public int findTargetSum(int arr[], int idx, int sum, int target){
        if(idx == arr.length){
            if(sum == target) return 1;
            return 0;
        }
        
        int val = findTargetSum(arr, idx + 1, sum - arr[idx], target);
        val += findTargetSum(arr, idx + 1, sum + arr[idx], target);
        
        return val;
    }
}