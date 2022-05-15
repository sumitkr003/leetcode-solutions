// https://leetcode.com/problems/arithmetic-slices

class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length < 3) return 0;
        int ans = 0;
        int d = arr[1] - arr[0];
        int count = 2;
        for(int i=2;i<arr.length;i++){
            if(arr[i] - arr[i-1] == d){
                count ++;
            }else{
                ans += ((count - 2) * (count - 1))/2;
                d = arr[i] - arr[i-1];
                count = 2;
            }
        }
        ans += ((count - 2) * (count - 1))/2;
        return ans; 
    }
}