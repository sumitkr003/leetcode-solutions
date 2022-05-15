// https://leetcode.com/problems/unique-binary-search-trees

class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=i;j++){
                sum += dp[j-1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}