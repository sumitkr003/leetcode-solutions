// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> ans = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return ans;
        }
        for(int i=0;i<nums1.length && i<k; i++){
            q.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k > 0 && !q.isEmpty()){
            int curr[] = q.poll();
            List<Integer> list = new ArrayList<>();
            // System.out.println(curr.length);
            list.add(curr[0]);
            list.add(curr[1]);
            
            ans.add(list);
            k--;
            if(curr[2] == nums2.length - 1){
                continue;
            }
            q.add(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
            
        }
        
        return ans;
    }
}