// https://leetcode.com/problems/range-addition-ii

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;
        for(int val[]: ops){
            int x = val[0];
            int y = val[1];
            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
        }
        return minX * minY;
    }
}