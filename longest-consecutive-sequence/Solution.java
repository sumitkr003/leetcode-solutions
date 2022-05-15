// https://leetcode.com/problems/longest-consecutive-sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        int count = 0;
        
        for(int val: set){
            if(!set.contains(val - 1)){
                int streak = 1;
                int num = val;
                
                while(set.contains(num + 1)){
                    streak++;
                    num++;
                }
                
                // System.out.println(val + " " + streak);
                count = Math.max(count, streak);
            }
        }
        
        return count;
    }
}