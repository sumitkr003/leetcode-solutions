// https://leetcode.com/problems/redundant-connection

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i+1, new HashSet<>());
        
        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // graph.get(4).remove(19);
        // graph.get(19).remove(4);
        // hasCycle(graph, new boolean[n+1], 1, -1);
        
        for(int i=n-1;i>=0;i--){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).remove(v);
            graph.get(v).remove(u);
            
            int src = (u == 1 || v == 1) ? ((u == 2 || v == 2) ? 3 : 2) : 1;
            boolean isVisited[] = new boolean[n+1];
            boolean flag = true;
            
            for(int j=1;j<=n;j++){
                if(!isVisited[j] && !hasCycle(graph, isVisited, j, -1)){
                    flag = false;
                }
            }
            
            if(flag) return edges[i];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return new int[2];
    }
    
    public boolean hasCycle(HashMap<Integer, HashSet<Integer>> graph,boolean isVisited[], int src, int parent){
        // System.out.println(src + " " + parent);
        if(isVisited[src]) return false;
        isVisited[src] = true;
        
        for(int neighbour: graph.get(src)){
            if(neighbour != parent){
                if(!hasCycle(graph, isVisited, neighbour, src)) return false;
            }
        }
        
        return true;
    }
}