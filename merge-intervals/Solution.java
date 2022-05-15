// https://leetcode.com/problems/merge-intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n < 2){
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int maxIntervals = 1;
        int curr = intervals[0][1];
        
        for(int i=1;i<n;i++){
            // System.out.println(curr + " " + intervals[i][0]);
            if(curr >= intervals[i][0]){
                curr = Math.max(curr, intervals[i][1]);
            }else{
                maxIntervals ++;
                curr = intervals[i][1];
            }
        }
        // System.out.println(maxIntervals);
        int ans[][] = new int[maxIntervals][2];
        ans[0][0] = intervals[0][0];
        int temp = 0;
        curr = intervals[0][1];
        for(int i=1;i<n;i++){
            if(curr >= intervals[i][0]){
                curr = Math.max(curr, intervals[i][1]);
                // ans[temp][0] = Math.min(ans[temp][0], intervals[i][0]);
            }else{
                ans[temp][1] = curr;
                temp++;
                curr = intervals[i][1];
                ans[temp][0] = intervals[i][0];
            }
        }
        ans[temp][1] = curr;
        return ans;
    }
}