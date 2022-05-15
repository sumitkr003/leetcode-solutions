// https://leetcode.com/problems/simplify-path

class Solution {
    public String simplifyPath(String path) {
        String str[] = path.split("/");
        Stack<String> st = new Stack<String>();
        for(String s: str){
            if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else if(!s.equals(".") && !s.equals("")){
                st.push(s);
            }
        }
        String ans = "";
        for(int i=0;i<st.size();i++){
            ans += "/" + st.get(i);
        }
        return ans.length() == 0 ? "/" : ans;
    }
}