// https://leetcode.com/problems/partition-array-for-maximum-sum

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        long ans[] = new long[n+1];
        ans[0] = 0;
        ans[1] = arr[0];
        for(int i=1;i<n;i++){
            long temp = arr[i] + ans[i];
            int max = arr[i];
            for(int j=i;j>i-k && j>=0;j--){
                max = Math.max(max, arr[j]);
                temp = Math.max(temp, (long)ans[j] + (long)(i-j+1) * (long)(max));
            }
            ans[i+1] = temp;
        }
        
        // System.out.println(Arrays.toString(ans));
        return (int)(ans[n]);
    }
}