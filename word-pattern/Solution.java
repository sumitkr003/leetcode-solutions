// https://leetcode.com/problems/word-pattern

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        
        String arr[] = str.split(" ");
        
        if(arr.length != pattern.length()){
            return false;
        }
        
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String s = arr[i];
            if(map.containsKey(ch) || map2.containsKey(s)){
                if(map.containsKey(ch) != map2.containsKey(s) || !map.get(ch).equals(s)){
                    return false;
                }
            }else{
                map.put(ch, s);
                map2.put(s, ch);
            }
        }
        
        return true;
    }
}