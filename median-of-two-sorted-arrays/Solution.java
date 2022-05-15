// https://leetcode.com/problems/median-of-two-sorted-arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int mid = (n+1)/2;
        double ans = 0;
        int l = Integer.MIN_VALUE, h = Integer.MAX_VALUE;
        
        while(l <= h){
            int m = (l + h)/2;
            int temp = lessthan(nums1, m);
            temp += lessthan(nums2, m);
            // System.out.println(l + " " + h);
            
            if(temp >= mid){
                h = m - 1;
            }else{
                l = m + 1;
            }
            
            if(l > h){
                ans = l;
            }
        }
        
        
        if(n % 2 == 0){
            mid ++;
            l = 0;
            h = Integer.MAX_VALUE;
            while(l <= h){
                int m = (l + h)/2;
                int temp = lessthan(nums1, m);
                temp += lessthan(nums2, m);
                // System.out.println(l + " " + h);

                if(temp >= mid){
                    h = m - 1;
                }else{
                    l = m + 1;
                }

                if(l > h){
                    ans += l;
                }
            }
            
            ans /= 2;
        }
        
        
        return ans;
    }
    
    public int lessthan(int arr[], int val){
        int l = 0, h = arr.length - 1;
        while(l <= h){
            int m = (l + h)/2;
            // System.out.println(l + " " + h);
            if(arr[m] > val){
                h = m - 1;
            }else{
                l = m + 1;
            }
        }
        
        return l;
    }
}