// https://leetcode.com/problems/check-if-a-string-can-break-another-string

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        boolean bool_a = true, bool_b = true;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            if(b[i] > a[i]){
                bool_a = false;
            }
            
            if(a[i] > b[i]){
                bool_b = false;
            }
        }
        return bool_a | bool_b;
    }
}