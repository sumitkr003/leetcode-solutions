// https://leetcode.com/problems/most-common-word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        paragraph = paragraph.toLowerCase();
        
//         for(String s : paragraph.split(" ")){
//             System.out.println(s);
//             if(map.containsKey(s)){
//                 map.put(s, map.get(s) + 1);
//             }else{
//                 map.put(s, 1);
//             }
//         }
        
        String temp = "";
        for(int i=0;i<paragraph.length();i++){
            char ch = paragraph.charAt(i);
            if(ch == ' ' || ch == '!' || ch == '?' || (int)ch == 39 || ch == ',' || ch == ';' || ch == '.'){
                
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                }else{
                    map.put(temp, 1);
                } 
                
                temp = "";
            }else{
                temp += ch;
            }
        }
        
        if(map.containsKey(temp)){
            map.put(temp, map.get(temp) + 1);
        }else{
            map.put(temp, 1);
        } 
        
        for(String s: banned){
            if(map.containsKey(s)){
                map.remove(s);
            }
        }
        
        String ans = "";
        for(String s : map.keySet()){
            if(ans.equals("")){
                ans = s;
            }else if(map.get(s) > map.get(ans)){
                ans = s;
            }
        }
        
        return ans;
    }
}