// https://leetcode.com/problems/contains-duplicate

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for(int val: nums){
            if(set.contains(val)) flag = true;
            else set.add(val);   
        }
        return flag;
    }
}