// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int f = 1;
        if(x < 0){
            x = -x;
            f = -1;
        }
        
        long num = 0;
        while(x > 0){
            int rem = x % 10;
            num = num * 10 + (long)rem;
            x /= 10;
        }
        
        if(num * f > Integer.MAX_VALUE || num * f < Integer.MIN_VALUE){
            return 0;
        }
        return (int)num * f;
    }
}