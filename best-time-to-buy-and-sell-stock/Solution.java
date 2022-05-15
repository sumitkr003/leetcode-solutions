// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int stock = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            profit = Math.max(profit, prices[i] - stock);
            stock = Math.min(stock, prices[i]);
        }
        return profit;
    }
}