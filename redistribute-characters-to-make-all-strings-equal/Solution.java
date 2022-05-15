// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal

class Solution {
    public boolean makeEqual(String[] words) {
        int f[] = new int[26];
        for(String w: words){
            for(char c: w.toCharArray()){
                f[c - 'a'] ++;
            }
        }
        
        int n = words.length;
        for(int i=0;i<26;i++){
            if(f[i] % n != 0) return false;
        }
        
        return true;
    }
}