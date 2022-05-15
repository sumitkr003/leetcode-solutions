// https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;
        Stack<Integer> st = new Stack<>();
        int i=0;
        while(i < heights.length){
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i);
                i++;
            }else{
                int top = st.peek();
                st.pop();
                
                int area_with_top = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
                
                max_area = Math.max(max_area, area_with_top);
            }
        }
        
        while(!st.isEmpty()){
            int top = st.peek();
            st.pop();
            
            int area_with_top = heights[top] * (st.isEmpty() ? i : i - st.peek() - 1);
            max_area = Math.max(max_area, area_with_top);
        }
        
        return max_area;
    }
}