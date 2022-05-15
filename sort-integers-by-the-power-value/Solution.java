// https://leetcode.com/problems/sort-integers-by-the-power-value

class Solution {
    public int getKth(int lo, int hi, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=lo;i<=hi;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(findPow(i));
            ans.add(temp);
        }
        Collections.sort(ans, (a, b) -> a.get(1) == b.get(1) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));
        return ans.get(k-1).get(0);
    }
    
    public int findPow(int val){
        int count = 0;
        while(val > 1){
            if(val % 2 == 0) val /= 2;
            else val = 3 * val + 1;
            count ++;
        }
        return count;
    }
}