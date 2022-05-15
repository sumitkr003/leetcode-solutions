// https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        
        int n = matrix[0].length;
        int max_area = 0;
        int arr[] = new int[n];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == '1'){
                    arr[j] ++;
                }else{
                    arr[j] = 0;
                }
            }
            
            max_area = Math.max(max_area, calculate(arr));
        }
        
        return max_area;
    }
    
    public int calculate(int heights[]){
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