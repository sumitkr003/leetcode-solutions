// https://leetcode.com/problems/distinct-subsequences-ii

class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        long freq[] = new long[26];
        long dp[] = new long[n];
        int mod = (int)(1e9+7);
        dp[0] = 1;
        freq[s.charAt(0) - 'a'] = 1;
        for(int i=1;i<n;i++){
            dp[i] = (long)2 * (long)dp[i-1] + 1;
            dp[i] -= (long)freq[s.charAt(i) - 'a'];
            if(dp[i] < 0) dp[i] += (long)(mod);
            freq[s.charAt(i) - 'a'] += dp[i] - dp[i-1];
            
            dp[i] %= mod;
            freq[s.charAt(i) - 'a'] %= mod;
        }
        
        return (int)(dp[n-1] % mod);
    }
}