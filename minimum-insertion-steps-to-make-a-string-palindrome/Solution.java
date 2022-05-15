// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int dp[][] = new int[n][n];
        int len = 1;
        while(len <= n){
            for(int i=0;i+len<=n;i++){
                if(len == 1){
                    dp[i][i] = 0;
                    continue;
                }
                if(arr[i] == arr[i+len-1]){
                    dp[i][i+len-1] = dp[i+1][i+len-2];
                }else{
                    dp[i][i+len-1] = Math.min(dp[i][i+len-2], dp[i+1][i+len-1]) + 1;
                }
            }
            len ++;
        }
        
        // for(int val[] : dp){
        //     for(int v : val){
        //         System.out.print(v + " ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1];
    }
}