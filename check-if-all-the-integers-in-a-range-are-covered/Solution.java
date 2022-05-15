// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int arr[] = new int[right - left + 1];
        for(int i=0;i<ranges.length;i++){
            int temp = ranges[i][0];
            while(temp <= ranges[i][1]){
                if(temp >= left && temp <= right){
                    arr[temp - left] ++;
                }
                temp ++;
            }
        }
        
        for(int val : arr) if(val == 0) return false;
        return true;
    }
}