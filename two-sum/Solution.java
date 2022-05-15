// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(target - nums[i])){
                int idx = map.get(target - nums[i]);
                int ans[] = {idx, i};
                return ans;
            }else{
                map.put(nums[i], i);
            }
        }
        
        return new int[0];
    }
}