// https://leetcode.com/problems/scramble-string

class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        String str = sb.toString();
        
        if(s1.equals(s2)){
            map.put(str, true);
            return true;
        } 
        if(map.containsKey(str)) return map.get(str);
        
        int freq[] = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i) - 'a'] ++;
            freq[s2.charAt(i) - 'a'] --;
        }
        for(int i=0;i<26;i++) 
            if(freq[i] != 0) {
                map.put(str, false);
                return false;
            }
        
        for(int i=1;i<s1.length();i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
                map.put(str, true);
                return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))){
                map.put(str, true);
                return true;
            }
        }
        
        map.put(str, false);
        return false;
    }
}