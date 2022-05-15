// https://leetcode.com/problems/leftmost-column-with-at-least-a-one

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        int ans = col;
        
        for(int i=0;i<row;i++){
            int l = 0, r = col - 1;
            while(l <= r){
                int mid = (int)((l + r)/2);
                if(binaryMatrix.get(i, mid) == 1){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            ans = Math.min(ans, l);
        }
        if(ans == col){
            ans = -1;
        }
        return ans;
    }
    
    public int binarySearch(BinaryMatrix binaryMatrix, int l, int r, int row){
        while(l <= r){
            int mid = (int)((l + r)/2);
            if(binaryMatrix.get(row, mid) == 1){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}