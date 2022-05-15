// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean isVisited[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(List<Integer> edge : edges){
            isVisited[edge.get(1)] = true;
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}