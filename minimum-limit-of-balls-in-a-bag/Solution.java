// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = (int)(1e9);
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int numOperations = getOperations(nums, mid);
            if(numOperations > maxOperations){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
    
    public int getOperations(int nums[], int val){
        int op = 0;
        for(int i=0;i<nums.length;i++){
            // op += nums[i] % val == 0 ? nums[i]/val : nums[i]/val + 1;
            op += (nums[i] - 1) / val;
        }
        return op;
    }
}