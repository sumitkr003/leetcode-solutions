// https://leetcode.com/problems/partition-array-into-disjoint-intervals

class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int val = nums[0];
        int ans = n;
        arr[n-1] = nums[n-1];
        
        for(int i=n-2;i>=0;i--) arr[i] = Math.min(arr[i+1], nums[i]);
        for(int i=0;i<n;i++){
            // System.out.println(val + " " + arr[i]);
            if(val <= arr[i]){
                ans = i;
                break;
            }
            val = Math.max(val, nums[i]);
        }
        return ans == 0 ? 1 : ans;
    }    
}