// https://leetcode.com/problems/add-strings

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i=0;
        for(i=0;i<num1.length() && i<num2.length();i++){
            int a = Integer.parseInt(num1.charAt(num1.length() - i - 1) + "");
            int b = Integer.parseInt(num2.charAt(num2.length() - i - 1) + "");
            int add = (a + b + carry);
            carry = add > 9 ? 1 : 0;
            add -= add > 9 ? 10 : 0;
            sb.append(add + "");
        }
        
        while(i < num1.length()){
            int a = Integer.parseInt(num1.charAt(num1.length() - i - 1) + "");
            int add = (a + carry);
            carry = add > 9 ? 1 : 0;
            add -= add > 9 ? 10 : 0;
            sb.append(add + "");
            i++;
        }
        
        while(i < num2.length()){
            int b = Integer.parseInt(num2.charAt(num2.length() - i - 1) + "");
            int add = (b + carry);
            carry = add > 9 ? 1 : 0;
            add -= add > 9 ? 10 : 0;
            sb.append(add + "");
            i++;
        }
        if(carry > 0) sb.append(carry);
        
        String str = sb.toString();
        sb = new StringBuilder();
        for(i=0;i<str.length();i++){
            sb.append(str.charAt(str.length() - i - 1));
        }
        return sb.toString();
    }
}