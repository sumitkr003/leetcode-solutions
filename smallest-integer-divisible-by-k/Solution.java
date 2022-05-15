// https://leetcode.com/problems/smallest-integer-divisible-by-k

class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int rem = 1;
        int len = 1;
        
        while(rem % k != 0){
            int n = rem * 10 + 1;
            rem = n % k;
            len ++;
        }
        
        return len;
    }
}