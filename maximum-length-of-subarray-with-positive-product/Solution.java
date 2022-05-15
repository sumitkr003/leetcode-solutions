// https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product

class Solution {
    public int getMaxLen(int[] arr) {
        int n = arr.length;
        int pos[] = new int[n];
        int neg[] = new int[n];
        if(arr[0] > 0){
            pos[0] = 1;
        }else if(arr[0] < 0){
            neg[0] = 1;
        }
        
        for(int i=1;i<n;i++){
            if(arr[i] == 0){
                pos[i] = 0;
                neg[i] = 0;
            }else if(arr[i] > 0){
                pos[i] = pos[i-1] + 1;
                neg[i] = neg[i-1] > 0 ? neg[i-1] + 1 : 0;
            }else{
                pos[i] = neg[i-1] > 0 ? neg[i-1] + 1 : 0;
                neg[i] = pos[i-1] + 1;
            }
        }
        
        int max = 0;
        for(int val : pos){
            System.out.println(val);
            max = Math.max(val, max);
        }
        return max;
    }
}