// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        
        setA.add(0);
        for(int i=0;i<n;i++){
            if(!visited[i]) dfs(graph, visited, new boolean[n], i, setA, setB);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                int dest = graph[i][j];
                if(!setA.contains(i) && !setA.contains(dest)) return false;
                if(!setB.contains(i) && !setB.contains(dest)) return false;
            }
        }
        
        return true;
    }
    
    public void dfs(int graph[][], boolean visited[], boolean dfs[], int src, HashSet<Integer> setA, HashSet<Integer> setB){
        
        if(dfs[src] || visited[src]) return;
        
        dfs[src] = true;
        
        // for(boolean val: dfs){
        //     if(val){
        //         System.out.print("T ");
        //     }else{
        //         System.out.print("F ");
        //     }
        // }
        // System.out.println(src);
        
        for(int i=0;i<graph[src].length;i++){
            if(!setA.contains(graph[src][i]) && !setB.contains(graph[src][i])){
                if(setA.contains(src)){
                    setB.add(graph[src][i]);
                }else{
                    setA.add(graph[src][i]);
                }
            }
            dfs(graph, visited, dfs, graph[src][i], setA, setB);
        }
        
        dfs[src] = false;
        visited[src] = true;
    }
}