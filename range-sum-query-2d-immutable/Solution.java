// https://leetcode.com/problems/range-sum-query-2d-immutable

class NumMatrix {
    private int sum[][];
    private int m,n;
    
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        sum = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
            }
        }
        
        for(int val[]: sum){
            for(int v: val){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        // System.out.println(sum[r2 + 1][c2 + 1] + " " + sum[r1][c2 + 1] + " " +  sum[r2 + 1][c1] + " " +  sum[r1][c1]);
        return sum[r2 + 1][c2 + 1] - sum[r1][c2 + 1] - sum[r2 + 1][c1] + sum[r1][c1]; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */