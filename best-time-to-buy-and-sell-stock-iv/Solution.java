// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0 || k == 0) return 0;
        int dp[][] = new int[k+1][n+1];
        
        for(int i=0;i<k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                max = Math.max(max, dp[i][j] - prices[j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j], prices[j] + max);
            }
        }
        
//      int temp = dp[i][j-1];
//      dp[i][j] = Math.max(temp, prices[i] - prices[j] + dp[i-1][j-1]);
        return dp[k][n];
    }
}