// https://leetcode.com/problems/course-schedule-ii

class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++) graph.put(i, new HashSet<>());
        for(int edge[] : prerequisites){
            int u = edge[1];
            int v = edge[0];
            graph.get(u).add(v);
        }
        HashSet<Integer> isDfsCompleted = new HashSet<>();
        for(int val: graph.keySet()){
            if(!isDfsCompleted.contains(val) && hasCycle(graph, val, isDfsCompleted, new HashSet<>())){
                return new int[]{};
            }
        }
//         ArrayList<Integer> arr = new ArrayList<>();
//         isVisited = new HashSet<>();
        
//         for(int val: graph.keySet()){
//             if(!isVisited.contains(val)){
//                 Queue<Integer> q = new LinkedList<>();
//                 q.add(val);
//                 while(!q.isEmpty()){
//                     int node = q.poll();
//                     if(!isDfsCompleted.contains(node)){
//                         arr.add(node);
//                         isDfsCompleted.add(node);
//                         for(int neigh : graph.get(node)){
                            
//                         }
//                     } 
//                 }
//             }
//         }
        int path[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            path[i] = ans.get(ans.size() - i - 1);
        }
        return path;
    }
    
    public boolean hasCycle(HashMap<Integer, HashSet<Integer>> graph, int src, HashSet<Integer> isDfsCompleted, HashSet<Integer> isVisited){
        if(isDfsCompleted.contains(src)) return false;
        if(isVisited.contains(src)) return true;
        isVisited.add(src);
        
        for(int val: graph.get(src)){
            if(hasCycle(graph, val, isDfsCompleted, isVisited)) return true;
        }
        ans.add(src);
        isVisited.remove(src);
        isDfsCompleted.add(src);
        
        return false;
    }
}