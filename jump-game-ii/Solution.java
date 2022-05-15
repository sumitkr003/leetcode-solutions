// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        int steps = 0, max = 0;
        int i=0, j=0;
        int n = nums.length;
        while(i < n && max < n-1){
            int temp = max;
            for(;i<=max && i<n;i++){
                temp = Math.max(temp, i + nums[i]);
                // System.out.println(i + nums[i]);
            }
            
            max = temp;
            steps ++;
        }
        
        return steps;
    }
}