// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0, count = 0;
        int dp[] = new int[s.length() + 1];
        
        for(int i=1;i<=s.length();i++){
            char ch = s.charAt(i-1);
            if(ch == '('){
                st.push(i);
            }else if(!st.isEmpty()){
                int j = st.pop();
                count = i - j + 1;
                count += dp[j-1];
                ans = Math.max(ans, count);
                dp[i] = count;
            }else{
                count = 0;
            }
        } 
        
        return ans;
    }
}