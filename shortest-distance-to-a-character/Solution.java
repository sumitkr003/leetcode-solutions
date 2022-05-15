// https://leetcode.com/problems/shortest-distance-to-a-character

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int arr[] = new int[n];
        int left = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == c){
                left = i;
            }
            arr[i] = left == Integer.MAX_VALUE ? Integer.MAX_VALUE : (i - left);
        }
        
        left = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == c){
                left = i;
            }
            arr[i] = left == Integer.MAX_VALUE ? arr[i] : Math.min(arr[i], (left - i));
        }
        
        return arr;
    }
}