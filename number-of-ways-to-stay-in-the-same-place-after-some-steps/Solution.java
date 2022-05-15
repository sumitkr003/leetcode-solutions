// https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps

class Solution {
    public int numWays(int steps, int n) {
        n = Math.min(251, n);
        long dp[][] = new long[steps + 1][n + 2];
        int mod = (int)(1e9+7);
        dp[0][1] = 1;
        
        for(int i=1;i<=steps;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1];
                dp[i][j] = dp[i][j] % mod;
            }
        }
        
        return (int)(dp[steps][1] % mod);
    }
}