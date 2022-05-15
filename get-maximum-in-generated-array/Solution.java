// https://leetcode.com/problems/get-maximum-in-generated-array

class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;
        for(int i=2;i<n+1;i++){
            if(i % 2 == 0){
                arr[i] = arr[i / 2];
            }else{
                arr[i] = arr[i/2] + arr[i/2 + 1];
            }
            max = Math.max(max, arr[i]);
        }
        // for(int val : arr){
        //     System.out.print(val + " ");
        // }
        return max;
    }
}