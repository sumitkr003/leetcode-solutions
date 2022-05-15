// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solve(nums, 0, new ArrayList<>(), new ArrayList<>());
    }
    
    public List<List<Integer>> solve(int nums[], int index, List<Integer> curr, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return ans;
        }
        
        if(index == 0 || curr.size() == 0) solve(nums, index + 1, curr, ans);
        else if(nums[index] != curr.get(curr.size() - 1)) solve(nums, index + 1, curr, ans);
        curr.add(nums[index]);
        solve(nums, index + 1, curr, ans);
        curr.remove(curr.size() - 1);
        return ans;
    }
}