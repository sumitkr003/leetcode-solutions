// https://leetcode.com/problems/find-the-duplicate-number

class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            if(set.contains(val)) return val;
            set.add(val);
        }
        return -1;
    }
}