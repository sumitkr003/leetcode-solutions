// https://leetcode.com/problems/redundant-connection-ii

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer, Node> graph = new HashMap<>();
        
        for(int i=1;i<=n;i++) graph.put(i, new Node());
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).neighbour.add(v);
            graph.get(v).parent.add(u);
        }
        
//         int u=4,v=2;
//         graph.get(u).neighbour.remove(v);
//         graph.get(v).parent.remove(u);
            
//         if(isRootedGraph(graph, n)) return edges[0];
        
        for(int i=n-1;i>=0;i--){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).neighbour.remove(v);
            graph.get(v).parent.remove(u);
            
            if(isRootedGraph(graph, n)) return edges[i];
            
            graph.get(u).neighbour.add(v);
            graph.get(v).parent.add(u);
        }
        
        return new int[2];
    }
    
    public boolean isRootedGraph(HashMap<Integer, Node> graph, int n){
        boolean hasMoreThanOneParent = true, allNodesVisited = true;
        int root = -1;
        for(int i=1;i<=n;i++){
            Node node = graph.get(i);
            if(node.parent.size() == 0 && node.neighbour.size() > 0) root = i;
            if(node.parent.size() > 1) hasMoreThanOneParent = false;
        }
        
        boolean isVisited[] = new boolean[n+1];
        if(root != -1) isConnectedGraph(graph, isVisited, root);
        
        for(int i=1;i<=n;i++) if(!isVisited[i]) allNodesVisited = false;
        // System.out.println(root + " " + hasMoreThanOneParent + " " + allNodesVisited);
        return root != -1 && hasMoreThanOneParent && allNodesVisited;
    }
    
    public boolean isConnectedGraph(HashMap<Integer, Node> graph, boolean isVisited[], int src){
        if(isVisited[src]){
            return false;
        }
        
        isVisited[src] = true;
        for(int n : graph.get(src).neighbour){
            if(!isConnectedGraph(graph, isVisited, n)) return false;
        }
        
        return true;
    }
}

public class Node{
    public HashSet<Integer> parent;
    public HashSet<Integer> neighbour;
    
    public Node(){
        parent = new HashSet<>();
        neighbour = new HashSet<>();
    }
}