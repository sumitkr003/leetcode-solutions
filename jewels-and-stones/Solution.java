// https://leetcode.com/problems/jewels-and-stones

class Solution {
    public int numJewelsInStones(String J, String S) {
        int freq[] = new int[256];
        for(int i=0;i<J.length();i++){
            freq[J.charAt(i)] ++;
        }
        
        int ans = 0;
        for(int i=0;i<S.length();i++){
            if(freq[S.charAt(i)] > 0){
                ans ++;
            }
        }
        return ans;
    }
}