// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()){
                if(T[i] >= T[st.peek()]){
                    st.pop();
                }else{
                    break;
                }
            }
            
            if(st.isEmpty()){
                ans[i] = 0;
            }else{
                ans[i] = st.peek() - i;
            }
            
            st.push(i);
        }
        return ans;
    }
}