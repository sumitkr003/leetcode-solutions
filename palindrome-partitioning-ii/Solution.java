// https://leetcode.com/problems/palindrome-partitioning-ii

class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int dp[] = new int[n];
        for(int i=0;i<n;i++) dp[i] = i;
        
        for(int mid=1;mid<n;mid++){
            for(int start=mid, end=mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++){
                dp[end] = Math.min(dp[end], start == 0 ? 0 : dp[start-1] + 1);
            }
            
            for(int start=mid-1, end=mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++){
                dp[end] = Math.min(dp[end], start == 0 ? 0 : dp[start-1] + 1);
            }
        }
        
        return dp[n-1];
    }
}