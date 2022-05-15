// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length - 1]) return nums[0];
        int pivot = findPivot(nums);
        return pivot == nums.length ? nums[0] : nums[pivot + 1];
    }
    
    public int findPivot(int arr[]){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(arr[mid] > arr[lo]){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}