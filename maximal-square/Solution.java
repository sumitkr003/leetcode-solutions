// https://leetcode.com/problems/maximal-square

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m < 1){
            return 0;
        }
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return ans * ans;
    }
}