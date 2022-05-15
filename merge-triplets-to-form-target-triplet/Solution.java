// https://leetcode.com/problems/merge-triplets-to-form-target-triplet

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int min = Integer.MIN_VALUE, n = triplets.length;
        int ans[] = new int[]{min, min, min};
        for(int i=0;i<n;i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                ans[0] = Math.max(ans[0], triplets[i][0]);
                ans[1] = Math.max(ans[1], triplets[i][1]);
                ans[2] = Math.max(ans[2], triplets[i][2]);
            }
        }
        // System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        return ans[0] == target[0] && ans[1] == target[1] && ans[2] == target[2];
    }
}