// https://leetcode.com/problems/matrix-block-sum

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int sumMatrix[][] = new int[m + 1][n + 1];
        int rangeSum[][] = new int[m + 1][n + 1];
        int ans[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                sumMatrix[i + 1][j + 1] = sumMatrix[i + 1][j] + sumMatrix[i][j + 1] - sumMatrix[i][j] + mat[i][j];
            
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int minR = Math.max(i - k, 0);
                int minC = Math.max(j - k, 0);
                int maxR = Math.min(i + k + 1, m);
                int maxC = Math.min(j + k + 1, n);
                ans[i][j] = sumMatrix[maxR][maxC] - sumMatrix[maxR][minC] - sumMatrix[minR][maxC] + sumMatrix[minR][minC];
            }
        }
        
        return ans;
    }
}