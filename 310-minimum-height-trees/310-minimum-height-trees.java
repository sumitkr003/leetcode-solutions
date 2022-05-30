class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        };
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new HashSet<>());
        }
        for(int edge[]: edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int nodesRemaining = n;
        List<Integer> leafs = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(graph.get(i).size() == 1) leafs.add(i);
        }
        
        while(nodesRemaining > 2 && leafs.size() > 0){
            List<Integer> newLeafs = new ArrayList<>();
            for(int u: leafs){
                int v = graph.get(u).iterator().next();
                graph.get(u).remove(v);
                graph.get(v).remove(u);
                nodesRemaining --;
                if(graph.get(v).size() == 1) newLeafs.add(v);
            }
            leafs = newLeafs;
        }
        
        for(int val: leafs){
            ans.add(val);
        }
        return ans;
    }
}