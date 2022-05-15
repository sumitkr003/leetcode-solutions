// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        long rev = 0;
        int num = x;
        int p = 0;
        while(num > 0){
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        
        return (int)rev == x;
    }
}