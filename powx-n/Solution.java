// https://leetcode.com/problems/powx-n

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        double f = myPow(x, Math.abs(n/2)); 
        double ans = n % 2 == 0 ? f * f : f * f * x;
        return n < 0 ? 1 / ans : ans;
    }
}