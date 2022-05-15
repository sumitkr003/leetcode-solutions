// https://leetcode.com/problems/remove-palindromic-subsequences

class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0) return 0;
        if(isPalindrome(s)) return 1;
        return 2;
    }
    
    public boolean isPalindrome(String s){
        int i=0;
        while(i < s.length() / 2){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
            i++;
        }
        return true;
    }
}