// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int ones[] = new int[m];
        
        for(int i=0;i<m;i++){
            ones[i] = binarySearch(mat[i]);
        }
        
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for(int i=0;i<m;i++){
            Q.add(new int[]{ones[i], i});
            
            if(Q.size() > k) Q.poll();
        }
        
        int ans[] = new int[k];
        while(k-- > 0){
            ans[k] = Q.poll()[1];
        }
        return ans;
    }
    
    public int binarySearch(int row[]){
        int lo = 0, hi = row.length;
        
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(row[mid] == 1){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
}