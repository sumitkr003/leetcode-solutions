// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQ =  new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pQ.add(stones[i]);
        }
        while(pQ.size() > 1){
            int x = pQ.poll();
            int y = pQ.poll();
            pQ.add(x-y);
        }
        int ans = pQ.poll();
        return ans;
    }
}