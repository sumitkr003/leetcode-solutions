// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length;i++){
            int val = 0;
            for(int j=i;j>=0;j--){
                val = val ^ arr[j];
                count += findK(arr, i+1, val);
            }
        }
        return count;
    }
    
    public static int findK(int arr[], int j, int val){
        int count = 0;
        int num = 0;
        
        for(int i=j;i<arr.length;i++){
            num = num ^ arr[i];
            if(num == val){
                count ++;
            }
        }
        
        return count;
    }
}