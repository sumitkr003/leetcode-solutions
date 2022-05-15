// https://leetcode.com/problems/max-consecutive-ones-iii

class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, i=0, j=0, n=nums.length, count = 0;
        while(j < n){
            if(nums[j] == 0){
                count ++;
            }
            
            while(count > k){
                if(nums[i] == 0) count --;
                i++;
            }
            // System.out.println(i + " " + j + " " + count);
            ans = Math.max(ans, j-i+1);
            j++;
        }
        
        return ans;
    }
}