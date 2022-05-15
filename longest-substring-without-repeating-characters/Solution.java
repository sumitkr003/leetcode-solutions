// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        int i=0, j=0;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(set.contains(ch)){
                while(i < j){
                    if(s.charAt(i) == ch){
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                }
            }else{
                set.add(ch);
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}