// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string

class Solution {
    public int minOperations(String str) {
        int zero = 0, one = 0;
        
        for(int i=0;i<str.length();i++){
            if(i%2 == 0){
                if(str.charAt(i) == '0'){
                    one ++;
                }else{
                    zero ++;
                }
            }else{
               if(str.charAt(i) == '1'){
                    one ++;
                }else{
                    zero ++;
                } 
            }
        }
        
        return Math.min(zero, one);
    }
}