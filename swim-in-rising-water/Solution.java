// https://leetcode.com/problems/swim-in-rising-water

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int ans = grid[0][0];
        boolean visited[][] = new boolean[n][n];
        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{ans, 0, 0});
        visited[0][0] = true;
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            ans = Math.max(curr[0], ans);
            int r = curr[1], c = curr[2];
            // System.out.print(curr[0] + " ");
            
            for(int i=0;i<dir.length;i++){
                int newR = r + dir[i][0], newC = c + dir[i][1];
                if(newR >= 0 && newR < n && newC >= 0 && newC < n && !visited[newR][newC]){
                    if(newR == n-1 && newC == n-1) return Math.max(ans, grid[n-1][n-1]);
                    // if(curr[0] == 16) System.out.println(grid[newR][newC]);
                    pq.add(new int[]{Math.max(ans, grid[newR][newC]), newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
        
        return -1;
    }
}