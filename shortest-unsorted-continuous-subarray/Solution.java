// https://leetcode.com/problems/shortest-unsorted-continuous-subarray

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int left = -1, right = -1;
        for(int i=0;i<n;i++){
            if(arr[i] != nums[i]){
                if(left == -1){
                    left = i;
                }else{
                    right = i;
                }
            }
        }
        
        return left == -1 ? 0 : right - left + 1;
    }
}