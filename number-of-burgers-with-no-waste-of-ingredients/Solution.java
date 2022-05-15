// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients

class Solution {
    public List<Integer> numOfBurgers(int t, int c) {
        List<Integer> ans = new ArrayList<>();
        int rem = t - 2 * c;
        if(rem % 2 == 1 || rem < 0){
            return ans;
        }
        
        int x = rem / 2;
        int y = c - x;
        
        if(x < 0 || y < 0){
            return ans;
        }
        
        ans.add(x);
        ans.add(y);
        return ans;
    }
}