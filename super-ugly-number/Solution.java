// https://leetcode.com/problems/super-ugly-number

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1){
            return 1;
        }
        
        int ans[] = new int[n];
        int idx[] = new int[primes.length];
        
        Arrays.fill(idx, 0);
        ans[0] = 1;
        
        for(int i=1;i<n;i++){
            int val = Integer.MAX_VALUE;
            int k = 0;
            for(int j=0;j<primes.length;j++){
                int num = primes[j] * ans[idx[j]];
                val = Math.min(val, num);
            }
            
            ans[i] = val;
            
            for(int j=0;j<primes.length;j++){
                int num = primes[j] * ans[idx[j]];
                idx[j] += num == val ? 1 : 0;
            }
        }
        
        // for(int val: ans){
        //     System.out.print(val + " ");
        // }
        return ans[n-1];
    }
}