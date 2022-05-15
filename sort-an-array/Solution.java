// https://leetcode.com/problems/sort-an-array

class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int[] mergeSort(int nums[], int l, int r){
        if(l == r) return new int[]{nums[l]};
        if(l > r) return new int[0];
        
        int mid = (l + r)/2;
        int left[] = mergeSort(nums, l, mid);
        int right[] = mergeSort(nums, mid+1, r);
        
        int mergedArray[] = new int[left.length + right.length];
        int i=0,j=0,k=0;
        while(k < left.length + right.length){
            if(i == left.length || (j < right.length && left[i] > right[j])){
                mergedArray[k] = right[j];
                j++;
            }else{
                mergedArray[k] = left[i];
                i++;
            }
            k++;
        }
        return mergedArray;
    }
}