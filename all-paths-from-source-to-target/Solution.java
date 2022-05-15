// https://leetcode.com/problems/all-paths-from-source-to-target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        return allPaths(0, n-1, graph, path);
    }
    
    public List<List<Integer>> allPaths(int src, int target, int graph[][], List<Integer> path){
        List<List<Integer>> ans = new ArrayList<>();
        
        if(src == target){
            ans.add(path);
            return ans;
        }

        for(int val: graph[src]){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(val);
            
            List<List<Integer>> newPath = allPaths(val, target, graph, temp);
            for(List<Integer> t : newPath){
                ans.add(t);
            }
        }
        
        return ans;
    }
    
}