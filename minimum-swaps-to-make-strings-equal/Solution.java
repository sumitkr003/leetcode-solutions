// https://leetcode.com/problems/minimum-swaps-to-make-strings-equal

class Solution {
    public int minimumSwap(String s1, String s2) {
        if(s1.length() != s2.length()){
            return -1;
        }
        
        int count1 = 0, count2 = 0;
        int x = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == 'x'){
                x++;
            }
        }
        
        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i) == 'x'){
                x++;
            }
        }
        
        int y = (s1.length() + s2.length()) - x;
        
        if(x % 2 != 0 || y % 2 != 0){
            return -1;
        }
        
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == ch2){
                continue;
            }
            if(ch1 == 'x' && ch2 == 'y'){
                count1++;
            }else{
                count2++;
            }
        }
        
        int ans = count1 / 2 + count2 / 2;
        count1 = count1 % 2;
        count2 = count2 % 2;
        
        if(count1 != count2){
            return 1;
        }
        
        ans += count1 + count2;
        return ans;
    }
}