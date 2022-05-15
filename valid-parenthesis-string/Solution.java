// https://leetcode.com/problems/valid-parenthesis-string

class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        char arr[] = s.toCharArray();
        int star = 0;
        for(int i=0;i<s.length();i++){
            if(arr[i] == '*'){
                star ++;
            }else if(arr[i] == '('){
                st.push(arr[i]);
            }else if(!st.isEmpty() && st.peek() == '('){
                st.pop();
            }else if(star > 0){
                star --;
            }else{
                return false;
            }
        }
        
        star = 0;
        for(int i=s.length()-1;i>=0;i--){
           if(arr[i] == '*'){
                star ++;
            }else if(arr[i] == ')'){
                st.push(arr[i]);
            }else if(!st.isEmpty() && st.peek() == ')'){
                st.pop();
            }else if(star > 0){
                star --;
            }else{
                return false;
            } 
        }
        
        return true;
    }
}