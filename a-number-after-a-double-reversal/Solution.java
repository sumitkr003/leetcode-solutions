// https://leetcode.com/problems/a-number-after-a-double-reversal

class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num == 0) return true;
        return num % 10 != 0;
    }
}