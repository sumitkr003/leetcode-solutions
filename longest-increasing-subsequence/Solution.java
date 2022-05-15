// https://leetcode.com/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        
        if(n < 1){
            return 0;
        }
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int len = 0;
            for(int j=i-1;j>=0;j--){
                if(arr[i] > arr[j]){
                    len = Math.max(len, dp[j]);
                }
            }
            dp[i] = len + 1;
        }
        
        int len = 1;
        for(int i=0;i<n;i++){
            len = Math.max(len , dp[i]);
        }
        return len;
    }
}