// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int val[] : edges){
            int x = val[0];
            int y = val[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        
        int count = 0;
        for(int val: graph[0]){
            boolean isVisited[] = new boolean[n];
            count += dfs(graph, val, isVisited, hasApple);
            // System.out.println(count + " " + val);
        }
        return count;
    }
    
    public int dfs(ArrayList<Integer> g[],int src, boolean isVisited[], List<Boolean> hasApple){
        if(isVisited[src]){
            return 0;
        }
        
        isVisited[src] = true;
        int count = 0;
        for(int n : g[src]){
            if(!isVisited[n] && n != 0){
                count += dfs(g, n, isVisited, hasApple);
            }
        }
        
        if(count > 0 || hasApple.get(src)){
            count += 2;
        }
        // System.out.println(src + " " + count);
        return count;
    }
    
}