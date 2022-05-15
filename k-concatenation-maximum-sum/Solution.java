// https://leetcode.com/problems/k-concatenation-maximum-sum

class Solution {
    public int kConcatenationMaxSum(int[] a, int k) {
        int n = a.length;
        int arr[] = new int[2*n];
        for(int i=0;i<2*n;i++){
            arr[i] = a[i % n];
        }
        
        // for(int val: arr){
        //     System.out.print(val + " ");
        // }
        // System.out.println();
        
        for(int i=1;i<2*n;i++){
            int sum = arr[i-1] + arr[i];
            if(sum > 0){
                arr[i] += arr[i-1];
            }else{
                arr[i] = 0;
            }
        }
        
        // for(int val: arr){
        //     System.out.print(val + " ");
        // }
        
        int first = 0;
        for(int i=0;i<n;i++){
            first = Math.max(first, arr[i]);
        }
        
        if(k == 1){
            return first;
        }
        
        int middle = 0;
        for(int i=0;i<2*n;i++){
            middle = Math.max(middle, arr[i]);
        }
        
        int last = 0, sum = 0, y = 0;
        first = 0;
        for(int i=0;i<n;i++){
            sum += a[i];
            y += a[n-i-1];
            last = Math.max(last, y);
            first = Math.max(first, sum);
        }
        
        long ans = Math.max((long)middle, (long)last + (long)(k - 2) * sum + (long)first);
        
        return (int)(ans % (long)(1e9+7));
    }
}