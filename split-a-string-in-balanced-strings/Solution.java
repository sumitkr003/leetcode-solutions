// https://leetcode.com/problems/split-a-string-in-balanced-strings

class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, count = 0;
        int n = s.length();
        char arr[] = s.toCharArray();
        for(int i=0;i<n;i++){
            if(arr[i] == 'L'){
                count ++;
            }else{
                count --;
            }
            
            ans += count == 0 ? 1 : 0;
        }
        return ans;
    }
}