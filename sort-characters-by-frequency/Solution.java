// https://leetcode.com/problems/sort-characters-by-frequency

class Solution {
    public String frequencySort(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(map.size() > 0){
            int freq = 0;
            char maxFreq = '!';
            for(char ch: map.keySet()){
                if(map.get(ch) > freq){
                    freq = map.get(ch);
                    maxFreq = ch;
                }
            }
            
            for(int i=0;i<freq;i++) sb.append(maxFreq);
            map.remove(maxFreq);
        }
        
        return sb.toString();
    }
}