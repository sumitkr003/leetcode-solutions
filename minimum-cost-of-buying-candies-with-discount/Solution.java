// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for(int val: cost) ans += val;
        for(int i=cost.length-3;i>=0;i-=3){
            ans -= cost[i];
        }
        return ans;
    }
}