// https://leetcode.com/problems/largest-plus-sign

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int arr[][] = new int[n][n];
        int ans = 0;
        for(int val[]: mines){
            int r = val[0];
            int c = val[1];
            arr[r][c] = 1;
        }
        
        for(int val[]: arr){
            for(int num: val){
                if(num == 0){
                    ans = 1;
                    break;
                }
            }
        }
        
        int dp[][][] = new int[n][n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){
                    continue;
                }else if(i == 0 && j == 0){
                    dp[i][j][0] = 1;
                    dp[i][j][1] = 1;
                }else if(i == 0){
                    dp[i][j][0] = 1;
                    dp[i][j][1] = dp[i][j-1][1] + 1;
                }else if(j == 0){
                    dp[i][j][0] = dp[i-1][j][0] + 1;
                    dp[i][j][1] = 1;
                }else{
                    dp[i][j][1] = dp[i][j-1][1] + 1;
                    dp[i][j][0] = dp[i-1][j][0] + 1;
                }
            }
        }
        
        
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(arr[i][j] == 1){
                    continue;
                }else if(i == n-1 && j == n-1){
                    dp[i][j][2] = 1;
                    dp[i][j][3] = 1;
                }else if(i == n-1){
                    dp[i][j][2] = dp[i][j+1][2] + 1;
                    dp[i][j][3] = 1;
                }else if(j == n-1){
                    dp[i][j][2] = 1;
                    dp[i][j][3] = dp[i+1][j][3] + 1;
                }else{
                    dp[i][j][2] = dp[i][j+1][2] + 1;
                    dp[i][j][3] = dp[i+1][j][3] + 1;
                }
                
                int temp = Math.min(dp[i][j][0], Math.min(dp[i][j][1], Math.min(dp[i][j][2], dp[i][j][3])));
                ans = Math.max(ans, temp);
            }
        }
        
        return ans;
    }
}