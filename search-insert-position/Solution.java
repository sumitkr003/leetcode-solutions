// https://leetcode.com/problems/search-insert-position

class Solution {
    public int searchInsert(int[] nums, int target) {
        return binary_search(nums, target, 0, nums.length - 1);
    }
    
    public int binary_search(int nums[], int val, int l, int r){
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == val){
                return mid;
            }else if(nums[mid] < val){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
            
        }
        
        return l;
    }
}