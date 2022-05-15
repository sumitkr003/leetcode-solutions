// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        
        String s = strs[0];
        int idx = s.length();
        for(int i=1;i<strs.length;i++){
            idx = Math.min(idx, strs[i].length());
            for(int j=0;j<idx && j<strs[i].length();j++){
                if(s.charAt(j) != strs[i].charAt(j)){
                    idx = j;
                    break;
                }
            }
        }
        
        return s.substring(0,idx);
    }
}