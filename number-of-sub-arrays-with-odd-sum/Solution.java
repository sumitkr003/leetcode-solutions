// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long odd[] = new long[n];
        long even[] = new long[n];
        if(arr[0] % 2 == 0) even[0]++;
        else odd[0]++;
        
        for(int i=1;i<n;i++){
            if(arr[i] % 2 == 0){
                even[i] = 1 + even[i-1];
                odd[i] = odd[i-1];
            }else{
                even[i] = odd[i-1];
                odd[i] = 1 + even[i-1];
            }
        }
        
        long ans = 0;
        for(long val: odd){
            ans += val;
            ans %= (long)(1e9+7);
        }
        
        return (int)(ans % (long)(1e9+7));
    }
}