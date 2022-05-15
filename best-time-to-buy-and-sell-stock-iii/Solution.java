// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[2][n+1];
        int profit = 0, curr = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            profit = Math.max(profit, prices[i] - curr);
            curr = Math.min(curr, prices[i]);
            dp[0][i+1] = profit;
        }
        
        int temp = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            // profit = dp[1][i];
            temp = Math.max(temp, dp[0][i] - prices[i]);
            // for(int j=i-1;j>=0;j--){
            //     profit = Math.max(profit, prices[i] - prices[j] + dp[0][j]);
            // }
            dp[1][i+1] = Math.max(dp[1][i], temp + prices[i]);
        }
        return dp[1][n];
    }
}