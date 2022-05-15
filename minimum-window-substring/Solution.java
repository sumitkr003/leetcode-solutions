// https://leetcode.com/problems/minimum-window-substring

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < 1 || t.length() < 1){
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        
        int count = 0;
        int start = 0, end = Integer.MAX_VALUE;
        int j = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0){
                    count ++;
                }
            }
               
            while(count == t.length()){
                // System.out.println(j + " " + i + " " + count);
                if(end-start > i-j+1){
                    start = j;
                    end = i + 1;
                }
                
                ch = s.charAt(j);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0){
                        count --;
                    }
                }
                j++;
            }
        }
               
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end); 
    }
}