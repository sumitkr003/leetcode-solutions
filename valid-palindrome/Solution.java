// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(!isAlphaNumeric(s.charAt(l))) l++;
            else if(!isAlphaNumeric(s.charAt(r))) r--;
            else if(toLower(s.charAt(l)) != toLower(s.charAt(r))){
                // System.out.println(s.charAt(l) + " " + s.charAt(r));
                return false;
            }
            else{
                l++;
                r--;
            }
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char ch){
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    
    public char toLower(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            return (char)(ch - 'A' + 'a');
        }
        return ch;
    }
}