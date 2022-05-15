// https://leetcode.com/problems/vowels-of-all-substrings

class Solution {
    boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c=='i' || c=='o' || c=='u')
            return true;
        return false;
    }
    public long countVowels(String word) {
        int n = word.length();
        long []dp = new long[n];
        long ans = 0;
        dp[0] = isVowel(word.charAt(0)) ? 1 :0;
        ans = dp[0];
        for(int i= 1;i<n;i++) {
            dp[i] = dp[i-1] + (isVowel(word.charAt(i)) ? i+1 : 0);
            ans+=dp[i];
        }
        return ans;
    }
}