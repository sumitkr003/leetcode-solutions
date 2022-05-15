// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    public int subarraySum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            ans += currSum == sum ? 1 : 0;
            ans += map.containsKey(currSum - sum) ? map.get(currSum - sum) : 0;
            if(map.containsKey(currSum)){
                map.put(currSum, map.get(currSum) + 1);
            }else{
                map.put(currSum, 1);
            }
        }
        return ans;
    }
}