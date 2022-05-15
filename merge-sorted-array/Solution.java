// https://leetcode.com/problems/merge-sorted-array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == nums1.length){
            return;
        }
        
        if(m == 0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        
        for(int i=0;i<m;i++){
            nums1[nums1.length - i - 1] = nums1[m - i - 1];
            nums1[m - i - 1] = 0;
        }
        
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i] + " ");
        }
        
        int i=0, j=nums1.length - m, k=0;
        while(i < nums1.length){
            if(j == nums1.length){
                nums1[i] = nums2[k];
                k++;
            }else if(k == nums2.length){
                nums1[i] = nums1[j];
                j++;
            }else if(nums1[j] > nums2[k]){
                nums1[i] = nums2[k];
                k++;
            }else{
                nums1[i] = nums1[j];
                j++;
            }
            i++;
        }
    }
}