class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int len = 0;
        for(int val: nums){
            int index = Arrays.binarySearch(dp, 0, len, val);
            if(index < 0) index = -(index + 1);
            dp[index] = val;
            if(index == len) len ++;
        }
        return len;
    }
}