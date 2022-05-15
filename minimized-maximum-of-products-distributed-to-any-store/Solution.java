// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store

class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int lo = 1, hi = 1;
        for(int val: arr) hi = Math.max(val, hi);
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            int count = 0;
            for(int val: arr){
                count += val / mid;
                count += val % mid == 0 ? 0 : 1;
            }
            
            if(count > n) lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}