// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        int l=0, r=1;
        for(int i=0;i<n-1;i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            if(len1 > ans){
                l = i - len1/2;
                r = i + len1/2 + 1;
                ans = len1;
            }
            if(len2 > ans){
                l = i - len2/2 + 1;
                r = i + len2/2 + 1;
                ans = len2;
            }
        }
        
        return s.substring(l, r);
    }
    
    public int expandAroundCenter(String s, int i, int j){
        int len = 1;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            len = j-i+1;
            i--;
            j++;
        }
        return len;
    }
}