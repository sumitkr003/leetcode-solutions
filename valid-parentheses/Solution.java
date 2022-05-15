// https://leetcode.com/problems/valid-parentheses

class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        if(s.length() > 0){
            st.push(0);
        }
        int i = 1;
        
        while(i < s.length()){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(i);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char ch = s.charAt(st.peek());
                st.pop();
                // System.out.println(ch + " " + s.charAt(i) + " " + (ch == '('));
                if(s.charAt(i) == ')' && ch == '('){
                    i++;
                    continue;
                }else if(s.charAt(i) == '}' && ch == '{'){
                    i++;
                    continue;
                }else if(s.charAt(i) == ']' && ch == '['){
                    i++;
                    continue;
                }else{
                    return false;
                }
            }
            i++;
        }
        
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}