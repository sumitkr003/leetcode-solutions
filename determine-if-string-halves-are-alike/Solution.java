// https://leetcode.com/problems/determine-if-string-halves-are-alike

class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        for(int i=0;i<s.length()/2;i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(s.length() - i - 1);
            count = addSub(c1, count, true);
            count = addSub(c2, count, false);
        }
        return count == 0;
    }
    
    public int addSub(char c, int count, boolean add){
        return isVowel(c) ? (add ? count + 1 : count - 1) : count;
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' ||
            c == 'u' || c == 'U';
    }
}