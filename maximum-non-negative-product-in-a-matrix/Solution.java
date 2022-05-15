// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix

class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long max_pos[][] = new long[m][n];
        long max_neg[][] = new long[m][n];
        
        max_pos[0][0] = grid[0][0];
        max_neg[0][0] = grid[0][0];
        
        for(int i=1;i<m;i++){
            max_pos[i][0] = max_pos[i-1][0] * grid[i][0];
            max_neg[i][0] = max_pos[i][0];
        }
        
        for(int i=1;i<n;i++){
            max_pos[0][i] = max_pos[0][i-1] * grid[0][i];
            max_neg[0][i] = max_pos[0][i];
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j] > 0){
                    max_pos[i][j] = grid[i][j] * Math.max(max_pos[i-1][j], max_pos[i][j-1]);
                    max_neg[i][j] = grid[i][j] * Math.min(max_neg[i-1][j], max_neg[i][j-1]);
                }else{
                    max_pos[i][j] = grid[i][j] * Math.min(max_neg[i-1][j], max_neg[i][j-1]);
                    max_neg[i][j] = grid[i][j] * Math.max(max_pos[i-1][j], max_pos[i][j-1]);
                }
            }
        }
        
        return max_pos[m-1][n-1] > -1 ? (int)(max_pos[m-1][n-1] % (long)(1e9+7)) : -1;
    }
}