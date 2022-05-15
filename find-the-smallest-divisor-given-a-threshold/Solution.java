// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for(int val: nums){
            // min = Math.min(min, val);
            max = Math.max(max, val);
        }
        
        // System.out.println(sum(nums, 9));
        return binary_search(1, max, nums, threshold);
    }
    
    public int binary_search(int l, int r, int nums[], int thres){
        while(l <= r){
            int mid = (l + r) / 2;
            int val = sum(nums, mid);
            // System.out.println(l + " " + r + " " + val);
            if(val <= thres){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    public int sum(int arr[], int n){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += (int)(Math.ceil((float)arr[i] / n));
        }
        return sum;
    }
}