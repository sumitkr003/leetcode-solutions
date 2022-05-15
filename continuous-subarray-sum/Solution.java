// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        int n = arr.length;
        if(n == 0){
            return false;
        }
        
        if(k == 0){
            for(int i=0;i<n;i++){
                int sum = arr[i];
                for(int j=i+1;j<n;j++){
                    sum += arr[j];
                    if(sum == 0){
                        return true;
                    }
                }
            }
            return false;
        }
        
        for(int i=0;i<n;i++){
            int sum = arr[i];
            for(int j=i+1;j<n;j++){
                sum += arr[j];
                if(sum % k == 0){
                    return true;
                }
            }
        }
        
        return false;
    }
}