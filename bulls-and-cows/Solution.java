// https://leetcode.com/problems/bulls-and-cows

class Solution {
    public String getHint(String secret, String guess) {
        int f[] = new int[10];
        int bulls = 0, cows = 0;
        for(int i=0;i<secret.length();i++){
            char ch = secret.charAt(i);
            if(i < guess.length() && ch == guess.charAt(i)){
                bulls ++;
            }else{
                f[ch - '0'] ++;   
            }
        }
        
        for(int i=0;i<secret.length() && i<guess.length();i++){
            if(secret.charAt(i) != guess.charAt(i) && f[guess.charAt(i) - '0'] > 0){
                cows ++;
                f[guess.charAt(i) - '0'] --;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}