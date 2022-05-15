// https://leetcode.com/problems/shortest-path-in-binary-matrix

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int ans = 0;
        int dir[][] = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> Q = new LinkedList<>();
        
        Q.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i=0;i<size;i++){
                int[] pop = Q.remove();
                
                if(pop[0] == n-1 && pop[1] == n-1){
                    return ans + 1;
                }
                
                for(int j=0;j<dir.length;j++){
                    int x = pop[0] + dir[j][0];
                    int y = pop[1] + dir[j][1];
                    
                    if(x>=0 && x<n && y>=0 && y<n && grid[x][y] == 0 && !visited[x][y]){
                        visited[x][y] = true;
                        Q.add(new int[]{x, y});
                    }
                }
            }
            
            ans ++;
        }
        
        return -1;
    }
}