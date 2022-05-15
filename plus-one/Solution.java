// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, n = digits.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<digits.length;i++){
            arr.add((carry + digits[n-i-1]) % 10);
            carry = carry + digits[n-i-1] > 9 ? 1 : 0;
        }
        
        if(carry == 1) arr.add(carry);
        
        n = arr.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = arr.get(n-i-1);
        }
        return ans;
    }
}