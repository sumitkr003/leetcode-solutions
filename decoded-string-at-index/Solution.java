// https://leetcode.com/problems/decoded-string-at-index

class Solution {
    public String decodeAtIndex(String s, int k) {
        // System.out.println(s + " " + k);
        char last = s.charAt(0);
        if(k == 0){
            for(char ch: s.toCharArray()){
                if(ch >= '0' && ch <= '9'){}
                else last = ch;
            }
            return last + "";
        }
        long count = 0;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int freq = Integer.parseInt(ch + "");
                count = count * freq;
                if(count > (long)k) return decodeAtIndex(str.toString(), (int)((long)k % (count/freq)));
            }else{
                count ++;
                last = ch;
            }
            str.append(ch);            
            if(count == k){
                System.out.println(count + " " + str.toString() + " " + ch);
                return last + "";
            } 
        }
        
        return "Not found";
    }
}