// https://leetcode.com/problems/missing-number

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for(int val: nums) sum -= val;
        return sum;
    }
}