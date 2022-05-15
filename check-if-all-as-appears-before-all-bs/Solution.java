// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs

class Solution {
    public boolean checkString(String s) {
        int a = -1, b = -1, i = 0;
        for(char ch: s.toCharArray()){
            if(ch == 'a') a = i;
            else if(ch == 'b' && b == -1) b = i;
            i++;
        }
        
        if(b == -1) return true;
        return a <= b;
    }
}