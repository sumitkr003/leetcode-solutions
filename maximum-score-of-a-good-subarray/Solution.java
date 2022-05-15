// https://leetcode.com/problems/maximum-score-of-a-good-subarray

class Solution {
    public int maximumScore(int[] nums, int k) {
        int ans = nums[k];
        int i=k-1,j=k+1, n=nums.length, min = ans;
        while(i >= 0 && j < n){
            if(nums[i] > nums[j]){
                min = Math.min(min, nums[i]);
                ans = Math.max(ans, min * (j-i));
                i--;
            }else{
                min = Math.min(min, nums[j]);
                ans = Math.max(ans, min * (j-i));
                j++;
            }
            // System.out.println(i + " " + j + " " + ans);
        }
        
        while(i >= 0){
            min = Math.min(min, nums[i]);
            ans = Math.max(ans, min * (j-i));
            i--;
            // System.out.println(i + " " + j + " " + ans);
        }
        
        while(j < n){
            min = Math.min(min, nums[j]);
            ans = Math.max(ans, min * (j-i));
            j++;
            // System.out.println(i + " " + j + " " + ans);
        }
        
        return ans;
    }
}