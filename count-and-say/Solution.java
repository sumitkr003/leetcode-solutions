// https://leetcode.com/problems/count-and-say

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        String prev = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        char curr = prev.charAt(0);
        int count = 1;
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i) == curr) count ++;
            else{
                ans.append(count);
                ans.append(curr);
                curr = prev.charAt(i);
                count = 1;
            }
        }
        
        ans.append(count);
        ans.append(curr);
        return ans.toString();
    }
}