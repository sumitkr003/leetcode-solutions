// https://leetcode.com/problems/break-a-palindrome

class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";
        for(int i=0;i<n;i++){
            if(i != n-i-1 && palindrome.charAt(i) != 'a'){
                // System.out.println(palindrome.substring(0, i) + "a" + palindrome.substring(i+1));
                return palindrome.substring(0, i) + "a" + palindrome.substring(i+1);
            }
        }
        
        return palindrome.substring(0, n-1) + "b";
    }
}