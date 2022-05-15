// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences

class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String str: sentences){
            int words = str.split(" ").length;
            ans = Math.max(ans, words);
        }
        return ans;
    }
}