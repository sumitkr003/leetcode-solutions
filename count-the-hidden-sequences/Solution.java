// https://leetcode.com/problems/count-the-hidden-sequences

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;
        long ans[] = new long[n+1];
        long max = 0, min =0;
        ans[0] = 0;
        
        for(int i=0;i<n;i++){
            ans[i+1] = ans[i] - (long)differences[i];
            min = Math.min(min, ans[i+1]);
            max = Math.max(max, ans[i+1]);
        }
        
        long count = (long)(upper - lower) - (long)(max - min) + 1;
        return count > 0 ? (int)count : 0;
    }
}