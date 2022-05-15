// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int r = mid / n;
            int c = mid - r * n;
            // System.out.println(mid + " " + r + " " + c);
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        
        return false;
    }
}