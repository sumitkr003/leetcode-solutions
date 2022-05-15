// https://leetcode.com/problems/find-all-anagrams-in-a-string

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length(), n = s.length();
        List<Integer> ans = new ArrayList<>();
        if(n < len) return ans;
        int freq[] = new int[26];
        for(int i=0;i<len;i++) freq[p.charAt(i) - 'a'] ++;
        for(int i=0;i<len;i++) freq[s.charAt(i) - 'a'] --;
        if(checkAnagram(freq)) ans.add(0);
        for(int i=len;i<n;i++){
            freq[s.charAt(i) - 'a'] --;
            freq[s.charAt(i - len) - 'a'] ++;
            if(checkAnagram(freq)) ans.add(i-len+1);
        }
        return ans;
    }
    
    public boolean checkAnagram(int freq[]){
        for(int val: freq) if(val != 0) return false;
        return true;
    }
}