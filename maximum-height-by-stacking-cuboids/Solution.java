// https://leetcode.com/problems/maximum-height-by-stacking-cuboids

class Solution {
    public int maxHeight(int[][] cuboids) {
        Arrays.sort(cuboids, (a, b) -> a[0] + a[1] + a[2] - b[0] - b[1] - b[2]);
        for(int val[]: cuboids) Arrays.sort(val);
        int ans = 0;
        int dp[] = new int[cuboids.length];
        for(int i=0;i<cuboids.length;i++){
            dp[i] = cuboids[i][2];
            for(int j=0;j<i;j++){
                if(cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]){
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}