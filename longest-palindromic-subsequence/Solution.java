// https://leetcode.com/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n <= 1){
            return n;
        }
        char arr[] = s.toCharArray();
        int dp[][] = new int[n][n];
        int len = 0;
        while(len < n){
            for(int i=0;i+len<n;i++){
                if(len == 0){
                    dp[i][i] = 1;
                    continue;
                }
                
                if(arr[i + len] == arr[i]){
                    dp[i][i+len] = dp[i+1][i+len-1] + 2;
                }else{
                    dp[i][i+len] = 
                        Math.max(dp[i][i+len-1], dp[i+1][i+len]);
                }
            }
            len++;                      
        }
        
        // for(int val[]: dp){
        //     for(int v: val){
        //         System.out.print(v + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1];                         
    }
}