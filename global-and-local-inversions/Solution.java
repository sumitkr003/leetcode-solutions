// https://leetcode.com/problems/global-and-local-inversions

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int localInversion = 0, globalInversion = 0;
        int n = nums.length;
        if(n == 1) return true;
        for(int i=0;i<n-1;i++) if(nums[i] > nums[i+1]) localInversion ++;
        int freq[] = new int[n];
        mergeSort(nums, freq, 0, n - 1);
        for(int val: freq) globalInversion += val;
        return localInversion == globalInversion;
    }
    
    public int[] mergeSort(int arr[], int freq[], int lo, int hi){
        if(lo == hi){
            int temp[] = {arr[lo]};
            return temp;
        }
        
        int mid = (lo + hi)/2;
        int left[] = mergeSort(arr, freq, lo, mid);
        int right[] = mergeSort(arr, freq, mid + 1, hi);
        
        return merge(left, right, freq);
    }
    
    public int[] merge(int left[], int right[], int freq[]){
        int i=0,j=0,k=0;
        int arr[] = new int[left.length + right.length];
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                freq[arr[k]] += left.length - i;
                j++;
            }
            k++;
        }
        
        while(i < left.length){
            arr[k] = left[i];
            i++;
            k++;
        }
        
        while(j < right.length){
            arr[k] = right[j];
            j++;
            k++;
        }
        
        return arr;
    }
}