// https://leetcode.com/problems/regular-expression-matching

class Solution {
    public boolean isMatch(String s, String p) {
        String temp = "";
        String star = "";
        
        if(p.length() == 0){
            if(s.length() == 0){
                return true;
            }else{
                return false;
            }
        }
        
        for(int i=0;i<p.length()-1;i++){
            if(p.charAt(i+1) == '*'){
                star += p.charAt(i);
                temp += '*';
                i++;
                continue;
            }else{
                temp += p.charAt(i);
            }
        }
        
        if(p.charAt(p.length() - 1) != '*'){
            temp += p.charAt(p.length() - 1);
        }
        System.out.println(temp + "     " + star);
        
        p = temp;
        
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=m;i++){
            if(p.charAt(i-1) == '*'){
                dp[i][0] = dp[i-1][0];
            }else{
                dp[i][0] = 0;
            }
        }
        
        for(int j=1;j<=n;j++){
            dp[0][j] = 0;
        }
        
        int k = 0;
        for(int i=1;i<=m;i++){
            char ch = p.charAt(i-1);
            boolean bool = false;
            if(ch == '*'){
                bool = true;
                ch = star.charAt(k);
                k++;
            }
            for(int j=1;j<=n;j++){
                // System.out.println(ch + " " + s.charAt(j-1) + " ");
                if(bool){
                    if(ch == '.' || ch == s.charAt(j-1)){
                        dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                    }else{
                        dp[i][j] = dp[i-1][j];  
                    }
                }else if(ch == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(ch == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                } 
            }
            // System.out.println("--------------");
        }
        
        for(int t[]: dp){
            for(int val: t){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        
        return dp[m][n] == 1;
    }
}