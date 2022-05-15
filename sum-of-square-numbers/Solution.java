// https://leetcode.com/problems/sum-of-square-numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        int num = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        int max = (int)(Math.pow(2, 31) - 1);
        while((long)num * (long)num <= (long)max){
            arr.add(num * num);
            num ++;
        }
        
        int lo = 0, hi = arr.size() - 1;
        while(lo <= hi){
            int sum = arr.get(lo) + arr.get(hi);
            if(sum == c) return true;
            else if(sum > c) hi --;
            else lo ++;
        }
        
        return false;
    }
}