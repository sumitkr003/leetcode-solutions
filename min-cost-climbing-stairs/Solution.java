// https://leetcode.com/problems/min-cost-climbing-stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans[] = new int[n + 1];
        for(int i=2;i<=n;i++){
            ans[i] = Math.min(ans[i-1] + cost[i-1], ans[i-2] + cost[i-2]);
        }
        return ans[n];
    }
}