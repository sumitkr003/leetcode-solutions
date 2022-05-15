// https://leetcode.com/problems/build-an-array-with-stack-operations

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int val = 1;
        while(i < target.length){
            while(val != target[i]){
                ans.add("Push");
                ans.add("Pop");
                val ++;
            }
            ans.add("Push");
            i++;
            val++;
        }
        return ans;
    }
}