// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val: nums){
            sum += val;
        }
        
        if(sum % 2 == 1){
            return false;
        }
        
        sum /= 2;
        int n = nums.length;
        int dp[] = new int[sum + 1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        
        dp[0] = -2;
        
        for(int i=0;i<n;i++){
            
            for(int j=0;j<dp.length;j++){
                
                if(dp[j] != -1 && dp[j] != i && j + nums[i] <= sum && dp[j + nums[i]] == -1){
                    dp[j + nums[i]] = i;                
                }
            }
            
            // for(int val: dp){
            //     System.out.print(val + " ");
            // }
            // System.out.println();
        }
        
        return dp[sum] != -1;
    }
}