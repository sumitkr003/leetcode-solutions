// https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.add(0);
        
        for(int row[] : mat){
            PriorityQueue<Integer> newPq = new PriorityQueue<Integer>(Collections.reverseOrder());
            for(int val: pq){
                for(int m: row){
                    newPq.add(val + m);
                    if(newPq.size() > k){
                        newPq.poll();
                    }
                }
            }
            // for(int val: newPq) System.out.print(val + " ");
            // System.out.println();
            pq = newPq;
        }
        
        // for(int val: pq) System.out.print(val + " ");
        return pq.poll();
    }
}