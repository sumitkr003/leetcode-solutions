// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times

class Solution {
    public boolean containsPattern(int[] arr, int m, int t) {
        int n = arr.length;
        for(int i=0;i<n-m;i++){
            int count = 0;
            for(int j=i+m;j<n;j++){
                if(arr[j] == arr[j - m]){
                    count ++;
                }else{
                    break;
                }
            }
            
            if(count / m + 1 >= t){
                return true;
            }
        }
        
        return false;
    }
}