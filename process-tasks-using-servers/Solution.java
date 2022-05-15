// https://leetcode.com/problems/process-tasks-using-servers

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> freeServers = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> occupiedServers = new PriorityQueue<int[]>((a,b) -> (a[2] != b[2]) ? (a[2] - b[2]) : ((a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1])));
        
//      FreeServer: server, index
//      occupiedServer : server, index, freeTime
        
        int ans[] = new int[tasks.length];
        
        for(int i=0;i<servers.length;i++) freeServers.add(new int[]{servers[i], i, 0});
        
        for(int i=0;i<tasks.length;i++){
            while(!occupiedServers.isEmpty() && occupiedServers.peek()[2] <= i)
                freeServers.add(occupiedServers.poll());
            
            // System.out.println(freeServers.size() + " " + occupiedServers.size());
            if(freeServers.isEmpty()){
                int s[] = occupiedServers.poll();
                ans[i] = s[1];
                s[2] += tasks[i];
                occupiedServers.add(s);
            }else{
                int s[] = freeServers.poll();
                ans[i] = s[1];
                s[2] = i + tasks[i];
                occupiedServers.add(s);
            }
        }
        
        return ans;
    }
}