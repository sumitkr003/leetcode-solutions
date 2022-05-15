// https://leetcode.com/problems/longest-harmonious-subsequence

class Solution {
    public int findLHS(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            if(map.containsKey(val)){
                map.put(val, map.get(val) + 1);
            }else{
                map.put(val, 1);
            }
            int temp = map.containsKey(val - 1) ? map.get(val - 1) : 0;
            temp = map.containsKey(val + 1) ? Math.max(temp, map.get(val + 1)) : temp;
            temp = temp == 0 ? 0 : map.get(val) + temp;
            
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}