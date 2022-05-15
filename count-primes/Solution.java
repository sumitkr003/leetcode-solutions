// https://leetcode.com/problems/count-primes

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean isPrime[] = new boolean[n];
        isPrime[0] = true;
        isPrime[1] = true;
        
        for(int i=2;i*i<n;i++){
            for(int j=2;j*i<n;j++){
                isPrime[i*j] = true;
            }
        }
        
        int count = 0;
        for(boolean val: isPrime) if(!val) count ++;
        return count;
    }
    
}