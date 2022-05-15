// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return solve(nums, 0, new ArrayList<>(), new ArrayList<>());
    }
    
    public List<List<Integer>> solve(int nums[], int index, List<Integer> curr, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        
        solve(nums, index + 1, curr, ans);
        curr.add(nums[index]);
        solve(nums, index + 1, curr, ans);
        curr.remove(curr.size() - 1);
        return ans;
    }
}