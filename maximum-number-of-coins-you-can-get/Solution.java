// https://leetcode.com/problems/maximum-number-of-coins-you-can-get

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int p = piles.length;
        int sum = 0;
        int i=0;
        while(i < p/3){
            sum += piles[p - 2*(i+1)];
            i++;
        }
        return sum;
    }
}