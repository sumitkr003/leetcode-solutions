// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        return solve(nums, 0);
    }
    
    public List<List<Integer>> solve(int nums[], int idx){
        int n = nums.length;
        if(idx == n-1){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> arr = new ArrayList<>();
            arr.add(nums[idx]);
            ans.add(arr);
            return ans;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> arr = solve(nums, idx + 1);
        
        int val = nums[idx];
        for(List<Integer> t : arr){
            t.add(0, val);
            ans.add(new ArrayList<>(t));
            t.remove(0);
        }
        
        for(List<Integer> t: arr){
            int size = t.size();
            for(int i=1;i<=size;i++){
                t.add(i, val);
                ans.add(new ArrayList<>(t));
                t.remove(i);
            }
        }
        
        return ans;
    }
    
    
}