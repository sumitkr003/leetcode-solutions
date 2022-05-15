// https://leetcode.com/problems/generate-parentheses

class Solution {
    public List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        solve(n,0,0,"");
        return ans;
    }
    
    public void solve(int n, int x, int y, String curr){
	    if(y == n){
	        ans.add(curr);
	        return;
	    }
	    
	    if(x < n){
	        curr += "(";
	        solve(n, x+1, y, curr);
	        curr = curr.substring(0, curr.length() - 1);
	    }
	    
	    if(y < n && y < x){
	        curr += ")";
	        solve(n, x, y+1, curr);
	        curr = curr.substring(0, curr.length() - 1);
	    }
	}
}