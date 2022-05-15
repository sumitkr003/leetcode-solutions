// https://leetcode.com/problems/count-number-of-homogenous-substrings

class Solution {
    public int countHomogenous(String str) {
        if(str.length() == 1){
            return 1;
        }
        long ans = 0;
        long mod = (long)(1e9+7);
        int freq = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                freq ++;
            }else{
                ans = (ans + ((long)freq * (long)(freq + 1)) / 2) % mod;
                // System.out.println(ans + " " + freq);
                freq = 1;
            }
        }
        ans = (ans + ((long)freq * (long)(freq + 1)) / 2) % mod;
        return (int)(ans % mod);
    }
}