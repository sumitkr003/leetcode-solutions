// https://leetcode.com/problems/pascals-triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for(int i=1;i<numRows;i++){
            temp = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j == 0 || j == i){
                    temp.add(1);
                    continue;
                }
                temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(temp);
        }
        return ans;
    }
}