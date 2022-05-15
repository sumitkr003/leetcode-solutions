// https://leetcode.com/problems/buddy-strings

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        
        int j = -1, k = -1;
        int n = A.length();
        for(int i=0;i<n;i++){
            if(A.charAt(i) != B.charAt(i)){
                if(j == -1){
                    j = i;
                }else{
                    k = i;
                }
            }
        }
        
        // System.out.println(j + " " + k);
        if(k == -1 && j == -1){
            int freq[] = new int[26];
            for(int i=0;i<n;i++){
                freq[A.charAt(i) - 'a'] ++;
                if(freq[A.charAt(i) - 'a'] > 1) return true;
            }
            return false;
        }else if(k == -1){
            return false;
        }
        
        for(int i=0;i<n;i++){
            if(A.charAt(i) != B.charAt(i)){
                if(i == j){
                    if(A.charAt(k) == B.charAt(i)){
                        continue;
                    }
                    return false;
                }else if(i == k){
                    if(A.charAt(j) == B.charAt(i)){
                        continue;
                    }
                    return false;
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
}