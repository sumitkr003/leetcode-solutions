// https://leetcode.com/problems/greatest-sum-divisible-by-three

class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[] = new int[3];
        
        for(int val: nums){
            int a = dp[0];
            int b = dp[1];
            int c = dp[2];
            
            int rem = (a + val) % 3;
            dp[rem] = Math.max(dp[rem], a + val);
            
            rem = (b + val) % 3;
            dp[rem] = Math.max(dp[rem], b + val);
            
            rem = (c + val) % 3;
            dp[rem] = Math.max(dp[rem], c + val);
        }
        
        return dp[0];
    }
}