// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for(String str: d){
            if(str.length() >= ans.length() && matchString(s, str)){
                if(str.length() > ans.length()){
                    ans = str;
                }else if(str.compareTo(ans) < 0){
                    ans = str;
                }
            }
        }
        return ans;
    }
    
    public boolean matchString(String str1, String str2){
        int i=0, j=0;
        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        return j == str2.length();
    }
}