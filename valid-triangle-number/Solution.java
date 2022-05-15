// https://leetcode.com/problems/valid-triangle-number

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int index = nums[i] + nums[j] > nums[n-1] ? n : binarySearch(nums, j + 1, n - 1, nums[i] + nums[j]);
                count += index - j - 1;
            }
        }
        return count;
    }
    
    public int binarySearch(int nums[], int lo, int hi, int val){
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < val){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}