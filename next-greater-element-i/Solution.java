// https://leetcode.com/problems/next-greater-element-i

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        // Arrays.sort(nums2);
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = solve(nums2, nums1[i]);
            // ans[i] = ans[i] == 0 ? -1 : ans[i];
        }
        
        return ans;
    }
    
    public int solve(int arr[], int num){
        // System.out.println(num);
        int i=0, n = arr.length;
        for(;i<n;i++){
            if(arr[i] == num){
                i++;
                break;
            }
        }
        
        for(;i<n;i++){
            if(arr[i] > num){
                return arr[i];
            }
        }
        return -1;
    }
}