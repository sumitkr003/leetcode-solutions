// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors

class Solution {
    public int twoEggDrop(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                int res = 1 + Math.max(j-1, dp[i-j]);
                dp[i] = Math.min(dp[i], res);
            }
        }
        return dp[n];
    }
}