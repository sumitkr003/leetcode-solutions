// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return nums;
        
        int ans[] = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0;i<n;i++){
//          remove elements outside window
            while(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.removeFirst();
            }
            
//          remove elemtts smaller than nums[i]   
            while(!dq.isEmpty() && nums[i] >= nums[dq.getLast()]){
                dq.removeLast();
            }
            
            dq.add(i);
            // System.out.println(i);
            // for(int index: dq) System.out.print(nums[index] + " ");
            // System.out.println();
            if(i >= k-1) ans[i-k+1] = nums[dq.getFirst()];
        }
        
        return ans;
    }
}