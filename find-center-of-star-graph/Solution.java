// https://leetcode.com/problems/find-center-of-star-graph

class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int val[] : edges){
            int u = val[0];
            int v = val[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        for(int val: map.keySet()){
            if(map.get(val).size() == n - 1) return val;
        }
        
        return -1;
    }
}