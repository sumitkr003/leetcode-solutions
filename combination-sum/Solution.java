// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<Integer>(), candidates, 0, target);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans, List<Integer> curr, int arr[], int idx, int sum){
        if(sum < 0){
            return;
        }
        
        if(sum == 0){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int val: curr){
                temp.add(val);
            }
            ans.add(temp);
        }
        
        for(int i=idx;i<arr.length;i++){
            curr.add(arr[i]);
            solve(ans, curr, arr, i, sum - arr[i]);
            curr.remove(curr.size() - 1);
        }
        
    }
}