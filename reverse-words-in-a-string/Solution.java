// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        String temp[] = s.split(" ");
        ArrayList<String> str = new ArrayList<>();
        for(String t: temp){
            if(!t.equals("")) str.add(t);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.size();i++){
            sb.append(str.get(str.size() - i - 1));
            if(i != str.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}