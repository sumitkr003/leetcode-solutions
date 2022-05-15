// https://leetcode.com/problems/combination-sum-ii

class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int sum) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<Integer>(), arr, 0, sum);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans, ArrayList<Integer> curr,
    int arr[], int idx, int sum){
        
        if(sum < 0){
            return;
        }else if(sum == 0){
            List<Integer> temp = new ArrayList<>();
            for(int val: curr){
                temp.add(val);
            }
            ans.add(temp);
        }
        
        int n = arr.length;
        for(int i=idx;i<n;i++){
            if(i > idx && arr[i] == arr[i-1]){
                continue;
            }
            curr.add(arr[i]);
            solve(ans, curr, arr, i+1, sum - arr[i]);
            curr.remove(curr.size() - 1);
        }
        
    }
}