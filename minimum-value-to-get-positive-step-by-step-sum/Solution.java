// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum

class Solution {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = 0;
        for(int val: nums){
            sum += val;
            if(sum < 1) ans = Math.max(ans, 1 - sum);
        }
        
        return ans; 
    } 
}