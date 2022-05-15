// https://leetcode.com/problems/string-to-integer-atoi

class Solution {
    public int myAtoi(String str) {
        str = remove_spaces(str);
        if(str.length() == 0){
            return 0;
        }
        
        int f = 1;
        if(str.charAt(0) == '-'){
            f = -1;
            str = str.substring(1);
        }else if(str.charAt(0) == '+'){
            f = 1;
            str = str.substring(1);
        }
        
        long num = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int val = ch - '0';
                num = num * 10 + (long)val;
            }else{
                break;
            }
            
            if(num * f > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(num * f < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        
        return (int)num * f;
    }
    
    public String remove_spaces(String str){
        while(str.length() > 0){
            if(str.charAt(0) == ' '){
                str = str.substring(1);
            }else{
                break;
            }
        }
        
        return str;
    }
}