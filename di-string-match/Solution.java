// https://leetcode.com/problems/di-string-match

class Solution {
    public int[] diStringMatch(String s) {
        int min = 0, max = s.length();
        int n = max;
        int ans[] = new int[n + 1];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                ans[i] = min;
                min ++;
            }else{
                ans[i] = max;
                max --;
            }
        }
        
        ans[n] = (min + max) / 2;
        return ans;
    }
}