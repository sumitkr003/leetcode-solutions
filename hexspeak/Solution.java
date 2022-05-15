// https://leetcode.com/problems/hexspeak

class Solution {
    public String toHexspeak(String str) {
        long num = Long.parseLong(str);
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        
        String ans = "";
        while(num > 0){
            int rem = (int)(num % 16);
            num = num / 16;
            
            if(rem > 1 && rem < 10){
                return "ERROR";
            }
            
            if(rem == 0){
                ans = "O" + ans;
            }else if(rem == 1){
                ans = "I" + ans;
            }else{
                ans = map.get(rem) + ans;
            }
        }
        
        return ans;
    }
}