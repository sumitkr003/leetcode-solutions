// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int currProfit = 0;
        int currStock = prices[0];
        
        for(int i=1;i<prices.length;i++){
            if(prices[i] <= prices[i-1]){
                ans += prices[i-1] - currStock;
                // System.out.println(currStock + " " + prices[i-1]);
                currStock = prices[i];
            }
        }
        
        if(prices[prices.length - 1] > currStock){
            ans += prices[prices.length - 1] - currStock;
        }
        
        return ans;
    }
}