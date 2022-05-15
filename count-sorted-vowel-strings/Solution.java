// https://leetcode.com/problems/count-sorted-vowel-strings

class Solution {
    public int countVowelStrings(int n) {
        if(n == 1) return 5;
        int dp[][] = new int[n][5];
        Arrays.fill(dp[0], 1);
        
        int sum = 5;
        for(int i=1;i<n;i++){
            for(int j=0;j<5;j++){
                if(j == 0) dp[i][j] = sum;
                else{
                    dp[i][j] = dp[i][j-1] - dp[i-1][j-1];
                    sum += dp[i][j];
                }
                    
            }
        }
        
        return sum;
    }
}