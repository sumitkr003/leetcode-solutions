// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<int[]> newRotten = new ArrayList<>();
            while(!queue.isEmpty()){
                int rotten[] = queue.remove();
                for(int i=0;i<dir.length;i++){
                    int nextX = rotten[0] + dir[i][0];
                    int nextY = rotten[1] + dir[i][1];
                    if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && grid[nextX][nextY] == 1){
                        newRotten.add(new int[]{nextX, nextY});
                        grid[nextX][nextY] = 2;
                    }
                }
            }
            
            if(newRotten.size() > 0){
                count ++;
                for(int val[]: newRotten){
                    queue.add(val);
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return count;
    }
}