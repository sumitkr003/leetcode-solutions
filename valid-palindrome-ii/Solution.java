// https://leetcode.com/problems/valid-palindrome-ii

class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, false) || isPalindrome(s, true);
    }
    
    public boolean isPalindrome(String s, boolean flag){
        int i=0, j=s.length()-1;
        int count = 0;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                count ++;
                if(flag) i++;
                else j--;
            }
        }
        
        if(count <= 1) return true;
        return false;
    }
}