// https://leetcode.com/problems/shifting-letters

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        for(int i=0;i<n;i++){
            shifts[n-i-1] %= 26;
            shifts[n-i-1] += i == 0 ? 0 : (shifts[n-i]);
            shifts[n-i-1] %= 26;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = (char)((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a');
            // System.out.println(ch);
            sb.append(ch);
        }
        return sb.toString();
    }
}