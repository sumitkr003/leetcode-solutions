// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> sq = new ArrayList<>();
        for(int i=1;i*i<=n;i++) sq.add(i*i);
        
        int dp[] = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<sq.size() && sq.get(j) <= i;j++){
                dp[i] = Math.min(dp[i], 1 + dp[i - sq.get(j)]);
            }
        }
        
        // for(int val: dp) System.out.print(val + " ");
        return dp[n];
    }
}