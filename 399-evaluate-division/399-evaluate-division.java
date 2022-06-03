class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Edge>> g = new HashMap<>();
        int n = values.length;
        for(int i=0;i<n;i++){
            List<String> e = equations.get(i);
            String u = e.get(0), v = e.get(1);
            double val = values[i];
            if(!g.containsKey(u)){
                g.put(u, new ArrayList<Edge>());
            }
            if(!g.containsKey(v)){
                g.put(v, new ArrayList<Edge>());
            }
            g.get(u).add(new Edge(v, val));
            g.get(v).add(new Edge(u, 1/val));
        }
        
        n = queries.size();
        double ans[] = new double[n];
        for(int i=0;i<n;i++){
            List<String> edge = queries.get(i);
            String u = edge.get(0), v = edge.get(1);
            if(u.equals(v)){
                if(g.containsKey(u)) ans[i] = 1.0;
                else ans[i] = -1.0;
                continue;
            }
            double a = dfs(g, u, v, new HashSet<>());
            double b = dfs(g, v, u, new HashSet<>());
            ans[i] = a != -1.0 ? a : 1/b;
        }
        return ans;
    }
    
    public double dfs(HashMap<String, ArrayList<Edge>> g, String src, String dest, HashSet<String> visited){
        if(visited.contains(src) || g.get(src) == null) return -1.0;
        
        visited.add(src);
        for(Edge edge: g.get(src)){
            if(edge.vertex.equals(dest)) return edge.weight;
            double d = dfs(g, edge.vertex, dest, visited);
            if(d != -1){
                return d * edge.weight;
            }
        }
        visited.remove(src);
        
        return -1.0;
    }
    
    public class Edge {
        public String vertex;
        public double weight;
        
        public Edge(String v, double w){
            this.vertex = v;
            this.weight = w;
        }
    }
}