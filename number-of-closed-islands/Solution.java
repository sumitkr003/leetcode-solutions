// https://leetcode.com/problems/number-of-closed-islands

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i=0;i<n;i++){
            dfs(grid, i, 0, n, m);
            dfs(grid, i, m-1, n, m);
        }
        
        for(int i=0;i<m;i++){
            dfs(grid, 0, i, n, m);
            dfs(grid, n-1, i, n, m);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        
        return count;
    }
    
    public void dfs(int grid[][], int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >= n || c >= m){
            return;
        }
        
        if(grid[r][c] == 1){
            return;
        }
        
        grid[r][c] = 1;
        dfs(grid, r+1, c, n, m);
        dfs(grid, r, c+1, n, m);
        dfs(grid, r-1, c, n, m);
        dfs(grid, r, c-1, n, m);
    }
}