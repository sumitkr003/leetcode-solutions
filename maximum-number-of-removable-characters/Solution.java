// https://leetcode.com/problems/maximum-number-of-removable-characters

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        char letters[] = s.toCharArray();
        int lo = 0, hi = removable.length;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            for(int i=0;i<mid;i++) letters[removable[i]] = '/';
            if(check(letters, p.toCharArray())) lo = mid + 1;
            else{
                for(int i=0;i<mid;i++) letters[removable[i]] = s.charAt(removable[i]);
                hi = mid - 1;
            }
        }
        
        return hi;
    }
    
    public boolean check(char s[], char p[]){
        int i = 0, j = 0;
        while(i < s.length && j < p.length){
            if(s[i] != '/' && s[i] == p[j]) j++;
            i++;
        }
        
        if(j == p.length) return true;
        return false;
    }
}