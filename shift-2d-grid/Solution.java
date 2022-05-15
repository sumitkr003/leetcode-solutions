// https://leetcode.com/problems/shift-2d-grid

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        while(k > 0){
            int prev = grid[m-1][n-1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int temp = grid[i][j];
                    grid[i][j] = prev;
                    prev = temp;
                }
            }
            k--;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int arr[]: grid){
            List<Integer> temp = new ArrayList<>();
            for(int val: arr){
                temp.add(val);
            }
            ans.add(temp);
        }
        return ans;
    }
}