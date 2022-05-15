// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii

class Solution {
    public int minSwaps(int[] nums) {
        int count = 0, n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] == 1) count ++;
        }
        
        int ans[] = new int[n];
        for(int i=0;i<count;i++){
            if(nums[i] == 0) ans[0] ++;
        }
        
        for(int i=1;i<n;i++){
            if(nums[i-1] == nums[(i+count-1) % n]) ans[i] = ans[i-1];
            else if(nums[i-1] == 0) ans[i] = ans[i-1] - 1;
            else ans[i] = ans[i-1] + 1;
        }
        
        int min = Integer.MAX_VALUE;
        for(int val: ans){
            // System.out.print(val + " ");
            min = Math.min(min, val);
        }
        return min > 0 ? min : 0;
    }
}