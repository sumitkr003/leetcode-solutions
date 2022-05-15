// https://leetcode.com/problems/minimum-time-to-make-rope-colorful

class Solution {
    public int minCost(String s, int[] cost) {
        int ans = 0;
        char arr[] = s.toCharArray();
        int i = 0, j = 1;
        while(j < arr.length && i >= 0){
            if(arr[i] == arr[j]){
                ans += Math.min(cost[i], cost[j]);
                if(cost[i] < cost[j]){
                    i = j;
                    j++;
                }else{
                    j++;
                }
            }else{
                i=j;
                j++;
            }
        }
        return ans;
    }
}