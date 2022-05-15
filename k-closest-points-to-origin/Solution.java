// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((b,a) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        int ans[][] = new int[k][2];
        
        for(int i=0;i<points.length;i++){
            if(q.size() == k){
                q.add(points[i]);
                q.poll();
            }else{
                q.add(points[i]);
            }
        }
        
        // System.out.println(q.size());
        int i=0;
        while(!q.isEmpty()){
            ans[i] = q.poll();
            i++;
        }
        
        return ans;
    }
}