// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<String> all_pos = new ArrayList<>();
        for(String str: arr){
            
            List<String> temp = new ArrayList<>();
            
            for(String s: all_pos){
                if(canCombine(str, s)){
                    temp.add(str + s);
                }
            }
            
            for(String s: temp){
                all_pos.add(s);
            }
            
            if(canCombine(str, "")){
                all_pos.add(str);
            }
        }
        
        int len = 0;
        for(String str: all_pos){
            len = Math.max(len, str.length());
        }
        
        return len;
    }
    
    public boolean canCombine(String s1, String s2){
        int f[] = new int[26];
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            f[ch - 'a']++;
            if(f[ch - 'a'] > 1){
                return false;
            }
        }
        
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            if(f[ch - 'a'] > 0){
                return false;
            }
        }
        
        return true;
    }
}