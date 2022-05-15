// https://leetcode.com/problems/reducing-dishes

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
//         int dp[][] = new int[n+1][n+1];
        
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=n;j++){
//                 if(i == 0 || j == 0) dp[i][j] = 0;
//                 else dp[i][j] = Integer.MIN_VALUE;
//             }
//         }
//         dp[1][1] = satisfaction[0];
        
//         for(int i=1;i<n;i++){
//             for(int j=0;j<=i;j++){
//                 int val = (j + 1) * satisfaction[i] + dp[i][j];
//                 dp[i+1][j+1] = Math.max(dp[i][j + 1], val);
//             }
//         }
        
//         for(int val[] : dp){
//             for(int v: val){
//                 System.out.print(v + " ");
//             }
//             System.out.println();
//         }
        
        int ans = 0;
//         for(int val: dp[n]) ans = Math.max(ans, val);                
        
        Arrays.sort(satisfaction);
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum += (j - i + 1) * satisfaction[j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}