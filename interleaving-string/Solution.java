// https://leetcode.com/problems/interleaving-string

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if(m + n != s3.length()){
            return false;
        }
        
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<=m;i++){
            int j = dp[i-1][0];
            if(s1.charAt(i-1) == s3.charAt(j)){
                dp[i][0] = j + 1;
            }else{
                dp[i][0] = 0;
            }
        }
        
        for(int i=1;i<=n;i++){
            int j = dp[0][i-1];
            if(s2.charAt(i-1) == s3.charAt(j)){
                dp[0][i] = j + 1;
            }else{
                dp[0][i] = 0;
            }
        }
        
        for(int i=1;i<=m;i++){
            char c1 = s1.charAt(i-1);
            for(int j=1;j<=n;j++){
                int k = dp[i-1][j-1];
                char c2 = s2.charAt(j-1);
                // System.out.println(c1 + " " + c2 + " " + s3.charAt(k) + " " + s3.charAt(k+1))
                if(s3.charAt(k) == c1 && s3.charAt(k+1) == c2){
                    dp[i][j] = k + 2;
                }else if(s3.charAt(k) == c2 && s3.charAt(k+1) == c1){
                    dp[i][j] = k + 2;
                }
                
                k = dp[i][j-1];
                if(s3.charAt(k) == c2){
                    dp[i][j] = Math.max(dp[i][j], k + 1);
                }
                
                k = dp[i-1][j];
                if(s3.charAt(k) == c1){
                    dp[i][j] = Math.max(dp[i][j], k + 1);
                }
            }
        }
        
        // for(int val[] : dp){
        //     for(int v: val){
        //         System.out.print(v + " ");
        //     }
        //     System.out.println();
        // }
        
        if(dp[m][n] == m + n){
            return true;
        }else{
            return false;
        }
    }
}