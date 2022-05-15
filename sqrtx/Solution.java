// https://leetcode.com/problems/sqrtx

class Solution {
    public int mySqrt(int x) {
        long val = (long)x;
        long lo = 0, hi = 2000000000;
        while(lo <= hi){
            long mid = (lo + hi) / 2;
            long pow = mid * mid;
            if(pow == val) return (int)mid;
            else if(pow > val) hi = mid - 1;
            else lo = mid + 1;
        }
        return (int)hi;
    }
}