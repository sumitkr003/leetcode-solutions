// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

class Solution {
    public String minRemoveToMakeValid(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        Stack<Integer> st = new Stack();
        for(int i=0;i<n;i++){
            char ch = arr[i];
            if(ch == '('){
              st.push(i);  
            }else if(ch == ')'){
                if(!st.isEmpty() && arr[st.peek()] == '('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        char ans[] = new char[n - st.size()];
        
        while(!st.isEmpty()){
            set.add(st.pop());
        }
        
        int j = 0;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                ans[j] = arr[i];
                j++;
            }
        }
        
        String temp = new String(ans);
        return temp;
    }
}