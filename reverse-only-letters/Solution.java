// https://leetcode.com/problems/reverse-only-letters

class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        char arr[] = new char[n];
        while(l <= r){
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);
            if(!(ch1 >= 'a' && ch1 <= 'z') && !(ch1 >= 'A' && ch1 <= 'Z')){
                arr[l] = ch1;
                l++;
            }else if(!(ch2 >= 'a' && ch2 <= 'z') && !(ch2 >= 'A' && ch2 <= 'Z')){
                arr[r] = ch2;
                r--;
            }else{
                arr[l] = ch2;
                arr[r] = ch1;
                l++;
                r--;
            }
        }
        
        return new String(arr);
    }
}