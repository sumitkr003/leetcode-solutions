// https://leetcode.com/problems/delete-tree-nodes

class Solution {
    public int root = -1;
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        ArrayList<Integer> list[] = new ArrayList[nodes];
        for(int i=0;i<nodes;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<parent.length;i++){
            int p = parent[i];
            if(p == -1){
                root = i;
            }else{
                list[p].add(i);
            }
        }
        
        dfs(list, parent, root, value);
        if(root == -2){
            return 0;
        }
        
        for(int i=0;i<nodes;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<parent.length;i++){
            int p = parent[i];
            if(p == -2){
                continue;
            }else if(p == -1){
                root = i;
            }else{
                list[p].add(i);
            }
        }
        
        int ans = count_nodes(list, root);
        return ans;
    }
    
    public int dfs(ArrayList<Integer> list[],int parent[], int node, int value[]){
        int val = 0;
        
        for(int child: list[node]){
            val += dfs(list, parent, child, value);
        }
        
        val += value[node];
        
        if(val == 0){
            if(parent[node] == -1){
                root = -2;
            }else{
                parent[node] = -2;
            }
        }
        
        return val;
    }
    
    public int count_nodes(ArrayList<Integer> list[], int node){
        int c = 1;
        
        for(int child: list[node]){
            c += count_nodes(list, child);
        }
        
        return c;
    }
}