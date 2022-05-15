// https://leetcode.com/problems/maximum-number-of-weeks-for-which-you-can-work

class Solution {
    public long numberOfWeeks(int[] arr) {
        long ans = 0, max = 0;
        for(int val: arr){
            ans += val;
            max = Math.max(max, val);
        }
        
        if(ans - max + 1 < max){
            ans = 2 * (ans - max) + 1;
        }
        return ans;
    }
}