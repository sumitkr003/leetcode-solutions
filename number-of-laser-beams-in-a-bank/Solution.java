// https://leetcode.com/problems/number-of-laser-beams-in-a-bank

class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, last = 0;
        for(int i=0;i<bank.length;i++){
            int temp = 0;
            for(char ch: bank[i].toCharArray()){
                if(ch == '1') temp ++;
            }
            
            if(temp != 0){
                ans += last * temp;
                last = temp;
            }
        }
        return ans;
    }
}