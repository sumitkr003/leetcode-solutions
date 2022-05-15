// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts

class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int mask = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        
        for(int i=0;i<s.length();i++){
            int index = ("aeiou".indexOf(s.charAt(i)));
            if(index > -1) mask = mask ^ (1 << index);
            if(!map.containsKey(mask)) map.put(mask, i);
            
            ans = Math.max(ans, i - map.get(mask));
        }
        
        return ans;
    }
}