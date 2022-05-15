// https://leetcode.com/problems/complex-number-multiplication

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String first[] = num1.split("\\+");
        String second[] = num2.split("\\+");
        int real1 = Integer.parseInt(first[0]);
        int img1 = Integer.parseInt(first[1].split("i")[0]);
        int real2 = Integer.parseInt(second[0]);
        int img2 = Integer.parseInt(second[1].split("i")[0]);
        // System.out.println(real1 + " " + img1);
        // System.out.println(real2 + " " + img2);
        
        int real = real1 * real2 - img1 * img2;
        int img = real1 * img2 + real2*img1;
        
        return real + "+" + img + "i";
    }
}