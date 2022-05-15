// https://leetcode.com/problems/edit-distance

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<=m;i++){
            dp[i][0] = i;
        }
        
        for(int i=1;i<=n;i++){
            dp[0][i] = i;
        }
        
        for(int i=1;i<=m;i++){
            char ch = word1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c = word2.charAt(j-1);
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                if(c != ch){
                    dp[i][j] ++;
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
}