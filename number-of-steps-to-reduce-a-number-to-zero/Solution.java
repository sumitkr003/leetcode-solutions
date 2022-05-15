// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero

class Solution {
    public int numberOfSteps (int num) {
        if(num == 0){
            return 0;
        }
        int ans = numberOfSteps(num % 2 == 0 ? num / 2 : num - 1) + 1;
        return ans;
    }
}