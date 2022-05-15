// https://leetcode.com/problems/count-of-smaller-numbers-after-self

class Solution {
    public List<Integer> countSmaller(int[] arr) {
        int n = n=arr.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int k = 0;
            for(int j=i+1;j<n;j++){
                k += arr[i] > arr[j] ? 1 : 0;
            }
            ans.add(k);
        }
        return ans;
    }
}