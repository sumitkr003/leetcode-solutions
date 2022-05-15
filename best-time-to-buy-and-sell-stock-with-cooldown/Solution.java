// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+2];
        for(int i=n-2;i>=0;i--){
            int val = 0;
            for(int j=i;j<n;j++){
                val = Math.max(val, Math.max(arr[j] - arr[i] + dp[j+2], dp[j+1]));
            }
            dp[i] = val;
        }
        for(int val : dp){
            System.out.print(val + " ");
        }
        return dp[0];
    }
}