// https://leetcode.com/problems/01-matrix

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int dp[][] = new int[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i][j] = r + c;
                if(mat[i][j] == 0) dp[i][j] = 0;
                if(i > 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                if(j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
            }
        }
        
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(mat[i][j] == 0) dp[i][j] = 0;
                if(i < r-1) dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                if(j < c-1) dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
            }
        }
        
        return dp;
    }
}