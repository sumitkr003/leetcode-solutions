// https://leetcode.com/problems/maximum-number-of-balloons

class Solution {
    public int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        for(int i=0;i<text.length();i++){
            freq[text.charAt(i) - 'a'] ++;
        }
        
        int ans = Integer.MAX_VALUE;
        for(char ch: "balon".toCharArray()){
            if(ch == 'l' || ch == 'o'){
                ans = Math.min(ans, freq[ch - 'a'] / 2);
            }else{
                ans = Math.min(ans, freq[ch - 'a']);
            }
        }
        return ans;
    }
}