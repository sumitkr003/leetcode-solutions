// https://leetcode.com/problems/find-the-k-beauty-of-a-number

class Solution {
    public int divisorSubstrings(int num, int k) {
        int pow = (int)(Math.pow(10, k));
        int ans = 0;
        int temp = num;
        while(num > 0 && ("" + num).length() >= k){
            int rem = num % pow;
            // System.out.println(rem + " " + num);
            if(rem != 0 && temp % rem == 0){
                // System.out.println(rem + " " + temp % rem);
                ans++;
            }
            num /= 10;
        }
        return ans;
    }
}