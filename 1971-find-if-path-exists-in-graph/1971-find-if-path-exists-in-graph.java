class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
        for(int i=0;i<n;i++){
            g.put(i, new ArrayList<>());
        }
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return dfs(g, source, destination, new boolean[n]);
    }
    
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> g, int src, int dest, boolean visited[]){
        if(visited[src]) return false;
        if(src == dest) return true;
        
        visited[src] = true;
        for(int val: g.get(src)){
            if(dfs(g, val, dest, visited)) return true;
        }
        return false;
    }
}