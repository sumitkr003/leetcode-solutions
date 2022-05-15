// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pos[] = new int[n];
        int neg[] = new int[n];
        pos[0] = nums[0];
        neg[0] = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] > 0){
                pos[i] = Math.max(nums[i], pos[i-1] * nums[i]);
                neg[i] = Math.min(nums[i], neg[i-1] * nums[i]);
            }else{
                neg[i] = Math.min(nums[i], pos[i-1] * nums[i]);
                pos[i] = Math.max(nums[i], neg[i-1] * nums[i]);
            }
        }
        
        // for(int i=0;i<n;i++) System.out.println(pos[i] + " " + neg[i]);
        
        int ans = Integer.MIN_VALUE;
        for(int val: pos) ans = Math.max(ans, val);
        return ans;
    }
}