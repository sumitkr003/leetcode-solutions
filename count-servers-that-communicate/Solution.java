// https://leetcode.com/problems/count-servers-that-communicate

class Solution {
    public int countServers(int[][] grid) {
        int ans = 0, count = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count ++;
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && solve(grid, i, j)){
                    ans ++;
                }
            }
        }
        
        return count - ans;
    }
    
    public boolean solve(int grid[][], int i, int j){
        int r = grid.length;
        int c = grid[0].length;
        
        grid[i][j] = 0;
        Stack<int[]> st = new Stack<>();
        int count = 0;
        int temp[] = new int[2];
        temp[0] = i;
        temp[1] = j;
        st.add(temp);
        
        while(!st.isEmpty()){
            temp = st.pop();
            int m = temp[0];
            int n = temp[1];
            count++;
            grid[m][n] = 0;
            
            
            for(i=0;i<r;i++){
                if(grid[i][n] == 1){
                    int t[] = new int[2];
                    t[0] = i;
                    t[1] = n;
                    st.push(t);
                }
            }
            
            for(i=0;i<c;i++){
                if(grid[m][i] == 1){
                    int t[] = new int[2];
                    t[0] = m;
                    t[1] = i;
                    st.push(t);
                }
            }
        }
        
        return count == 1;
    }
}