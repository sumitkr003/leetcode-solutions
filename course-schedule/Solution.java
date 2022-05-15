// https://leetcode.com/problems/course-schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int edge[] : prerequisites){
            int u = edge[1];
            int v = edge[0];
            if(!graph.containsKey(u)) graph.put(u, new HashSet<>());
            if(!graph.containsKey(v)) graph.put(v, new HashSet<>());
            graph.get(u).add(v);
        }
        HashSet<Integer> isDfsCompleted = new HashSet<>();
        // for(int val: graph.keySet()){
        //     System.out.print(val + "->");
        //     for(int node : graph.get(val)) System.out.print(node + ",");
        //     System.out.println();
        // }
        for(int val: graph.keySet()){
            // System.out.println(val + "----------");
            if(!isDfsCompleted.contains(val) && hasCycle(graph, val, isDfsCompleted, new HashSet<>())){
                return false;
            }
        }
        return true;
    }
    
    public boolean hasCycle(HashMap<Integer, HashSet<Integer>> graph, int src, HashSet<Integer> isDfsCompleted, HashSet<Integer> isVisited){
        // System.out.println(src + " " + isVisited.contains(src));
        if(isDfsCompleted.contains(src)) return false;
        if(isVisited.contains(src)) return true;
        isVisited.add(src);
        
        for(int val: graph.get(src)){
            if(hasCycle(graph, val, isDfsCompleted, isVisited)) return true;
        }
        isVisited.remove(src);
        isDfsCompleted.add(src);
        
        return false;
    }
}