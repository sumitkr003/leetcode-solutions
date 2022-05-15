// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            max_area = Math.max(max_area, Math.min(height[l], height[r]) * (r-l));
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        
        return max_area;
    }
}