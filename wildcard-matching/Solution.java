// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
       if(s==null && p==null) return true;
        if(s==null || p==null) return false;
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=0;i<n;i++){
            if(p.charAt(i)=='*')
                dp[0][i+1] = true;
            else break;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(p.charAt(j)!='*'){
                    dp[i+1][j+1] = dp[i][j] && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?');
                }
                else{
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        return dp[m][n]; 
    }
}