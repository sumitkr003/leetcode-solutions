// https://leetcode.com/problems/integer-to-roman

class Solution {
    public String intToRoman(int num) {
        return solve(num);
    }
    
    public String solve(int num) {
        if(num == 0) return "";
        
        if(num >= 1000){
            return "M" + solve(num - 1000);
        }else if(num >= 900){
            return "CM" + solve(num - 900);
        }else if(num >= 500){
            return "D" + solve(num - 500);
        }else if(num >= 400){
            return "CD" + solve(num - 400);
        }else if(num >= 100){
            return "C" + solve(num - 100);
        }else if(num >= 90){
            return "XC" + solve(num - 90);
        }else if(num >= 50){
            return "L" + solve(num - 50);
        }else if(num >= 40){
            return "XL" + solve(num - 40);
        }else if(num >= 10){
            return "X" + solve(num - 10);
        }else if(num >= 9){
            return "IX" + solve(num - 9);
        }else if(num >= 5){
            return "V" + solve(num - 5);
        }else if(num >= 4){
            return "IV" + solve(num - 4);
        }else if(num == 3){
            return "III";
        }else if(num == 2){
            return "II";
        }else {
            return "I";
        }
        // switch(num){
        //     case 4 : return 'IV';
        //     case 9 : return 'IX';
        //     case 40: return 'XL';
        //     case 90: return 'XC';
        //     case 400: return 'CD';
        //     case 900: return 'CM';
        // }
        // return "";
    }
}