// https://leetcode.com/problems/distinct-subsequences

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[][] = new int[m + 1][n + 1];
        for(int i=0;i<=n;i++){
            dp[0][i] = 1;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = dp[i+1][j];
                if(s.charAt(j) == t.charAt(i)){
                    dp[i+1][j+1] += dp[i][j];
                }
            }
        }
        
        return dp[m][n];
    }
}