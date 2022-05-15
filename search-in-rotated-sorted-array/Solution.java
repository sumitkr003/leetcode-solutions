// https://leetcode.com/problems/search-in-rotated-sorted-array

class Solution {
    public int search(int[] arr, int target) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        // System.out.println(pivot);
        if(binarySearch(arr, 0, pivot, target) != -1){
            return binarySearch(arr, 0, pivot, target);
        }
        return binarySearch(arr, pivot + 1, arr.length - 1, target);
    }
    
    public int findPivot(int arr[], int l, int r){
        while(l < r){
            if(l == r - 1){
                if(arr[r] > arr[l]){
                    return r;
                }
                return l;
            }
            int mid = (l + r) /2;
            // System.out.println(l + " " + r);
            if(arr[mid] > arr[l]){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }
    
    public int binarySearch(int arr[], int l, int r, int target){
        while(l <= r){
            int mid = (r+l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}