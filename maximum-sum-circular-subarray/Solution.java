// https://leetcode.com/problems/maximum-sum-circular-subarray

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int sum = 0, ans = nums[0];
        int maxSum[] = new int[n];
        int minSum[] = new int[n];
        for(int i=0;i<n;i++){
            sum += nums[i];
            maxSum[i] = Math.max(nums[i], (i == 0 ? 0 : maxSum[i-1]) + nums[i]);
            minSum[i] = Math.min(nums[i], (i == 0 ? 0 : minSum[i-1]) + nums[i]);
        }
        
        for(int i=0;i<n;i++){
            // System.out.println(maxSum[i] + " " + minSum[i] + " " + (sum - minSum[i]));
            if(sum != minSum[i]) ans = Math.max(ans, Math.max(maxSum[i], sum - minSum[i]));
            else ans = Math.max(ans, maxSum[i]);
        }
        return ans;
    }
}