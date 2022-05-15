// https://leetcode.com/problems/three-divisors

class Solution {
    public boolean isThree(int n) {
        int count = 2;
        for(int i=2;i*i<=n;i++){
            if(n % i == 0){
                count ++;
                if(n/i != i) count ++;
            }
            if(count > 3) return false;
        }
        return count == 3;
    }
}