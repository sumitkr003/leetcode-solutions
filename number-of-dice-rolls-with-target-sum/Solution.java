// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum

class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int dp[][] = new int[d+1][target + 1];
        long mod = (long)(1e9+7);
        for(int i=1;i<=f && i<=target;i++){
            dp[1][i] = 1;
        }
        
        for(int i=2;i<=d;i++){
            for(int j=1;j<=target;j++){
                long sum = 0;
                for(int k=1;k<=f && j-k>=0;k++){
                    sum += dp[i-1][j-k];
                    sum %= mod;
                }
                sum %= mod;
                dp[i][j] = (int)sum;
            }
        }
        return dp[d][target];
    }
}