// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target);
    }
    
    public boolean binarySearch(int nums[], int target){
        int lo = 0, hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            // System.out.println(lo + " " + hi);
            if(nums[mid] == target || nums[lo] == target || nums[hi] == target) return true;
            if(nums[mid] > nums[lo]){
                if(target < nums[lo] || target > nums[mid]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }else if(nums[mid] < nums[hi]){
                if(target < nums[mid] || target > nums[hi]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else{
                lo++;
            }
        }
        return false;
    }
}