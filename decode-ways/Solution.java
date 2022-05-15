// https://leetcode.com/problems/decode-ways

class Solution {
    public int numDecodings(String str) {
        return solve(str);
    }
    
    public int solve(String str){
        int n = str.length();
        int arr[] = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i+1] = Integer.parseInt(str.charAt(i) + "");
        }
        
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int x = arr[i-1] * 10 + arr[i];
            int y = arr[i];
            
            if((x > 9 && x < 27) || (y > 0)){
                if(y > 0){
                    dp[i] = dp[i-1];
                }
                
                if(x > 9 && x < 27){
                    dp[i] += dp[i-2];
                }
            }else{
                return 0;
            }
        }
        
        return dp[n];
    }
}