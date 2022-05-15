// https://leetcode.com/problems/grid-game

class Solution {
    public long gridGame(int[][] grid) {
        int m = 2, n = grid[0].length;
        long dp[][] = new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j == 0) dp[i][j] = (long)grid[i][j];
                else dp[i][j] = dp[i][j-1] + grid[i][j];
            }
        }
        
        long ans = dp[0][n-1] - dp[0][0];
        for(int i=1;i<n;i++){
            // System.out.println((dp[0][n-1] - dp[0][i]) + " " + dp[1][i-1]);
            ans = Math.min(ans, Math.max(dp[1][i-1], dp[0][n-1] - dp[0][i]));
        }
        return ans;
    }
}