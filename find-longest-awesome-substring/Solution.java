// https://leetcode.com/problems/find-longest-awesome-substring

class Solution {
    public int longestAwesome(String s) {
        int ans = 0, mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> powOfTwo = new HashMap<>();
        
        map.put(0, -1);
        for(int i=0;i<10;i++){
            powOfTwo.put(1 << i, -1);
        }
        
        for(int i=0;i<s.length();i++){
            mask = mask ^ (1 << (s.charAt(i) - '0'));
            if(!map.containsKey(mask)) map.put(mask, i);
            
            // even length
            ans = Math.max(ans, i - map.get(mask));
            if(powOfTwo.containsKey(mask)) ans = i + 1;
            
            //odd length
            int temp = 1;
            while(temp < 1 << 10){
                int diff = -1;
                if((mask ^ temp) < mask){
                    diff = mask - temp;
                }else{
                    diff = mask + temp;
                }
                
                if(map.containsKey(diff) && (i - map.get(diff)) % 2 != 0){
                    ans = Math.max(ans, i - map.get(diff));
                }

                temp *= 2;
            }
            
            // System.out.println(ans + " " + mask);
        }
        
        return ans;
    }
}