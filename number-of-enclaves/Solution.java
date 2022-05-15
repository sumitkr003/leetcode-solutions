// https://leetcode.com/problems/number-of-enclaves

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean visited[][] = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(visited, grid, i, 0, n, m);
            }
            
            if(grid[i][m-1] == 1){
                dfs(visited, grid, i, m-1, n, m);
            }
        }
        
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(visited, grid, 0, i, n, m);
            }
            
            if(grid[n-1][i] == 1){
                dfs(visited, grid, n-1, i, n, m);
            }
        }
        
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count ++;
                }
            }
        }
        return count;
    }
    
    public void dfs(boolean visited[][], int grid[][], int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >= n || c >= m){
            return;
        }
        
        if(grid[r][c] == 0 || visited[r][c]){
            return;
        }
        
        visited[r][c] = true;
        
        dfs(visited, grid, r+1, c, n, m);
        dfs(visited, grid, r, c+1, n, m);
        dfs(visited, grid, r-1, c, n, m);
        dfs(visited, grid, r, c-1, n, m);
    }
}