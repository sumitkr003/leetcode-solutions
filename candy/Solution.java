// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1] && ans[i] <= ans[i-1]){
                ans[i] = ans[i-1] + 1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1] && ans[i] <= ans[i+1]){
                ans[i] = ans[i+1] + 1;
            }
        }
        
        int count = 0;
        for(int val: ans) count += val;
        
        return count;
    }
}