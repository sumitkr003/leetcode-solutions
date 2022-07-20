class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean isVisited[] = new boolean[n];
        int provinces = 0;
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(isConnected, i, isVisited, n);
                provinces ++;
            }
        }
        return provinces;
    }
    
    public void dfs(int graph[][], int src, boolean isVisited[], int vertices){
        isVisited[src] = true;
        
        for(int i=0;i<vertices;i++){
            if(graph[src][i] == 1 && !isVisited[i]) dfs(graph, i, isVisited, vertices);
        }
    }
}