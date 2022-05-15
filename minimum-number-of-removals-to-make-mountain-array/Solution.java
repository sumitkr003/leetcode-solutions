// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int increasing[] = new int[n];
        int decreasing[] = new int[n];
        for(int i=1;i<n;i++){
            int longestIncreasing = 0;
            int longestDecreasing = 0;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]) longestIncreasing = Math.max(longestIncreasing, increasing[j] + 1);
                if(nums[n-i-1] > nums[n-j-1]) longestDecreasing = Math.max(longestDecreasing, decreasing[n-j-1] + 1);
            }
            increasing[i] = longestIncreasing;
            decreasing[n-i-1] = longestDecreasing;
        }
        
        int maxBiotonicLength = 0;
        for(int i=0;i<n;i++){
            // System.out.println(increasing[i] + " " + decreasing[i]);
            if(increasing[i] > 0 && decreasing[i] > 0){
                maxBiotonicLength = Math.max(maxBiotonicLength, increasing[i] + decreasing[i] + 1);
            }
        }
        return nums.length - maxBiotonicLength;
    }
}