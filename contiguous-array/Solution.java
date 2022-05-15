// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int curr = 0;
        map.put(curr,0);
        for(int i=0;i<nums.length;i++){
            curr += nums[i] == 0 ? 1 : -1;
            if(curr == 0){
                ans = Math.max(ans, i+1);
            }
            if(map.containsKey(curr)){
                ans = Math.max(i - map.get(curr), ans);
            }else{
                map.put(curr, i);
            }
        }
        return ans;
    }
}