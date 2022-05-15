// https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int sMapping[] = new int[256];
        int tMapping[] = new int[256];
        Arrays.fill(sMapping, -1);
        Arrays.fill(tMapping, -1);
        
        for(int i=0;i<s.length();i++){
            int j = s.charAt(i);
            int k = t.charAt(i);
            
            if(sMapping[j] == -1 && tMapping[k] == -1){
                sMapping[j] = k;
                tMapping[k] = j;
            }else if(sMapping[j] == -1 || tMapping[k] == -1){
                return false;
            }
            
            if(sMapping[j] != k || tMapping[k] != j) return false;
        }
        
        return true;
    }
}