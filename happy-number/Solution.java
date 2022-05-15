// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n > 1){
            int newNumber = squareDigits(n);
            if(set.contains(n)){
                return false;
            }else{
                set.add(n);
                n = newNumber;
            }
        }
        
        if(n == 1){
            return true;
        }
        return false;
    }
    
    public int squareDigits(int n){
        int squareSum = 0;
        
        while(n > 0){
            int rem = n % 10;
            squareSum += rem * rem;
            n /= 10;
        }
        
        return squareSum;
    }
}