// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        int x = (int)(Math.sqrt(num));
        if(x * x == num){
            return true;
        }
        return false;
    }
    
    // public int binarySearch(int num){
    //     int l = 0, r = 
    // }
}