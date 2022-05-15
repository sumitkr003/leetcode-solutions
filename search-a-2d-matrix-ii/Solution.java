// https://leetcode.com/problems/search-a-2d-matrix-ii

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(binarySearch(matrix[i], target)) return true;
        }
        return false;
    }
    
    public boolean binarySearch(int arr[], int val){
        int lo = 0, hi = arr.length - 1;
        if(arr[lo] > val) return false;
        while(lo <= hi){
            int mid= (lo + hi) / 2;
            if(arr[mid] == val) return true;
            if(arr[mid] > val){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return false;
    }
}