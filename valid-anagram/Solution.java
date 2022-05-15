// https://leetcode.com/problems/valid-anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        char freq[] = new char[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i) - 'a']++;
        
        for(int i=0;i<t.length();i++) freq[t.charAt(i) - 'a']--;
        
        for(int i=0;i<26;i++)
            if(freq[i] != 0) return false;
        
        return true;
    }
}