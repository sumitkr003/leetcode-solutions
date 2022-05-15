// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> S1 = new Stack<>();
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '#' && !S1.isEmpty()){
                S1.pop();
            }else if(c != '#'){
                S1.push(c);
            }
        }
        
        Stack<Character> T1 = new Stack<>();
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(c == '#' && !T1.isEmpty()){
                T1.pop();
            }else if(c != '#'){
                T1.push(c);
            }
        }
        
        while(!S1.isEmpty() && !T1.isEmpty()){
            System.out.println(S1.peek() + " " + T1.peek());
            if(S1.pop() != T1.pop()){
                return false;
            }
        }
        
        System.out.println(S1.isEmpty() + " " + T1.isEmpty());
        if(S1.isEmpty() != T1.isEmpty()){
            return false;
        }
        return true;
    }
}